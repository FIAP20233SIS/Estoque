package br.com.fiap.estoque.domain.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.estoque.domain.dao.EstoqueDAOImpl;
import br.com.fiap.estoque.domain.model.VerificaEspacoDTO;
import br.com.fiap.estoque.domain.model.VerificaEspacoResponseDTO;
import br.com.fiap.estoque.domain.usecase.EstoqueUsecase;
import br.com.fiap.estoque.domain.validations.StockValidator;
import br.com.fiap.estoque.infrastructure.LoggingModule;
import br.com.fiap.estoque.infrastructure.exception.BusinessException;
import br.com.fiap.estoque.utils.Calculos;
import br.com.fiap.estoque.utils.Mappers;
import br.com.fiap.estoque.utils.Providers;

@Service
public class EstoqueImpl implements EstoqueUsecase {
	
	@Autowired
	private EstoqueDAOImpl estoqueDAO;
	
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
	
	public String movimentarEstoque(VerificaEspacoDTO model) throws BusinessException {
		LoggingModule.info("iniciando método: movimentarEstoque(model)]");

		this.callValidators(model);
		
        List<Double> values = Providers.createSideSizeValuesList(model);
        Integer tamanho = Calculos.verificaTamanho(values);
        
        Map<Integer, String> sizeMap = Mappers.sizeMapper();
        String produtoIncluido = sizeMap.getOrDefault(tamanho, "Não cabe");
		
		LoggingModule.info("finalizando método: movimentarEstoque(model)]");
        return produtoIncluido;
	}
	
	private void callValidators(VerificaEspacoDTO model) {
		LoggingModule.debug("[" + this.getClass().getName() + "] " +  "iniciando chamada dos validators... ");
		validators.forEach(v -> {
			try {
				v.validate(model);
			} catch (BusinessException e) {
				e.printStackTrace();
				LoggingModule.debug("[" + this.getClass().getName() + "] " + "Erro nos validadores: ");
			}
		});
		LoggingModule.debug("[" + this.getClass().getName() + "] " +  "finalizando chamada dos validators. ");
	}

}
