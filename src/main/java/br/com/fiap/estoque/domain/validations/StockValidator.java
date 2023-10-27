package br.com.fiap.estoque.domain.validations;

import br.com.fiap.estoque.domain.model.VerificaEspacoDTO;
import br.com.fiap.estoque.infrastructure.exception.BusinessException;

public interface StockValidator {

	void validate(VerificaEspacoDTO dados) throws BusinessException;
	
}
