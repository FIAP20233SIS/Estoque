package br.com.fiap.estoque.domain.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.estoque.domain.dao.EstoqueDAOImpl;
import br.com.fiap.estoque.domain.dao.PrateleiraDAOImpl;
import br.com.fiap.estoque.domain.model.MovimentacaoEstoqueDTO;
import br.com.fiap.estoque.domain.model.VerificaEspacoDTO;
import br.com.fiap.estoque.domain.model.VerificaEspacoResponseDTO;
import br.com.fiap.estoque.domain.usecase.EstoqueUsecase;
import br.com.fiap.estoque.domain.validations.StockValidator;
import br.com.fiap.estoque.infrastructure.LoggingModule;
import br.com.fiap.estoque.infrastructure.exception.BusinessException;
import br.com.fiap.estoque.utils.Calculos;

@Service
public class EstoqueImpl implements EstoqueUsecase {

	@Autowired
	private EstoqueDAOImpl estoqueDAO;
	
	@Autowired
	private PrateleiraDAOImpl prateleiraDAO;

	@Autowired
	private List<StockValidator> validators;

	@Override
	public VerificaEspacoResponseDTO verificarEstoque(VerificaEspacoDTO verificaDTO) {
		LoggingModule.info("iniciando método: verificarEstoque(verificaDTO)]");

		Double volume = Calculos.calcularVolume(verificaDTO.largura(), verificaDTO.altura(), verificaDTO.profundidade());
		LoggingModule.debug("Volume no service: " + volume.toString());

		Long qtdeLugaresDisponiveis = estoqueDAO.countEstoqueByTamanhoWithEmptyPrateleira(volume);
		LoggingModule.debug("Quantidade de lugares encontrados: " + qtdeLugaresDisponiveis);

		LoggingModule.info("finalizando método: verificarEstoque(verificaDTO)]");
		return new VerificaEspacoResponseDTO(qtdeLugaresDisponiveis);
	}

	public MovimentacaoEstoqueDTO movimentarEstoque(VerificaEspacoDTO model) throws BusinessException {
		LoggingModule.info("iniciando método: movimentarEstoque(model)]");

		this.callValidators(model);

		var movimentacao = this.movimentarEstoqueBanco(model, Calculos.calcularVolume(model.largura(), model.altura(), model.profundidade()));
		
		if (movimentacao == null) {
			LoggingModule.warn("Não foi possível realizar a movimentação.");
			throw new BusinessException("Não foi possível realizar a movimentação.");
		}

		LoggingModule.info("finalizando método: movimentarEstoque(model)]");
		
		return movimentacao;
	}
	
	private MovimentacaoEstoqueDTO movimentarEstoqueBanco(VerificaEspacoDTO model, Double tamanho) throws BusinessException {
		int tipoMovimentacao = model.tipoMovimentacao().getType();
		MovimentacaoEstoqueDTO movimentacao = null;
		
		if (tipoMovimentacao == 0) {
			// realizar lógica para verificação se o produto realmente está no estoque antes de chamar o update.
			estoqueDAO.retiradaEstoque(model.codigoBarras());
		} else {
			List<BigDecimal> prateleirasDisponiveis = prateleiraDAO.obterPrateleirasVaziasPorTamanho(tamanho);
			
			// verifica primeiro se já tem um produto com esse código de barras no estoque
			
			// TODO -> criar validador para isso.
			String hasProduto = estoqueDAO.obterEstoquePorCodigoProduto(model.codigoBarras());
			if (hasProduto != null && !hasProduto.isEmpty()) {
				throw new BusinessException("Já existe um produto com este código de barras no estoque.");
			}
			
			Long idPrateleira = null;
			
			// TODO -> criar validador para isso.
			if (prateleirasDisponiveis != null && !prateleirasDisponiveis.isEmpty()) {
				idPrateleira = prateleirasDisponiveis.get(0).longValue();
			} else {
				throw new BusinessException("Não há prateleiras disponíveis para o tamanho desse produto.");
			}
			
			//--- realiza a inclusão da prateleira
			int numRowsUpdated = estoqueDAO.incluirEstoque(model.codigoBarras(), idPrateleira);
			LoggingModule.debug("Linhas atualizadas na inclusão do estoque: " + numRowsUpdated);
			
			// verifica se realmente o produto foi inserido no estoque.
			if (numRowsUpdated > 0) {
				movimentacao = new MovimentacaoEstoqueDTO();
				movimentacao.setNumRowsUpdated(numRowsUpdated);
				movimentacao.setPrateleiraId(idPrateleira);
				movimentacao.setCodProduto(model.codigoBarras());
				movimentacao.setTamanhoPrateleira(tamanho);
			}
		}

		return movimentacao;
	}

	private void callValidators(VerificaEspacoDTO model) {
		LoggingModule.debug("[" + this.getClass().getName() + "] " + "iniciando chamada dos validators... ");
		validators.forEach(v -> {
			try {
				v.validate(model);
			} catch (BusinessException e) {
				e.printStackTrace();
				LoggingModule.error("[" + this.getClass().getName() + "] " + "Erro nos validadores: ");
			}
		});
		LoggingModule.debug("[" + this.getClass().getName() + "] " + "finalizando chamada dos validators. ");
	}

}
