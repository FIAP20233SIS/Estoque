package br.com.fiap.estoque.domain.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.estoque.domain.model.MovimentacaoRequestDTO;
import br.com.fiap.estoque.domain.model.VerificaEstoqueDTO;
import br.com.fiap.estoque.domain.service.EstoqueImpl;
import br.com.fiap.estoque.infrastructure.LoggingModule;
import br.com.fiap.estoque.infrastructure.exception.BusinessException;

@Component
public class StockSizeMovementValidator implements StockValidator {
	
	@Autowired
	private EstoqueImpl estoqueService;

	@Override
	public void validate(MovimentacaoRequestDTO dados) throws BusinessException {
		var estoque = estoqueService.verificarEstoque(new VerificaEstoqueDTO(dados.largura(), dados.altura(), dados.profundidade()));
		
		if (estoque.lugaresDisponiveis().intValue() == 0) {
			LoggingModule.debug("Não há espaço suficiente para o produto " + dados.codigoBarras() + ".");
			throw new BusinessException("Não há espaço suficiente para esse produto.");
		}
	}

}
