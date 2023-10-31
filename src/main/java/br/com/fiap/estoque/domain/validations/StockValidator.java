package br.com.fiap.estoque.domain.validations;

import br.com.fiap.estoque.domain.model.MovimentacaoRequestDTO;
import br.com.fiap.estoque.infrastructure.exception.BusinessException;

public interface StockValidator {

	void validate(MovimentacaoRequestDTO dados) throws BusinessException;
	
}
