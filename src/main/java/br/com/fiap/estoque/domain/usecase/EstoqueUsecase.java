package br.com.fiap.estoque.domain.usecase;

import br.com.fiap.estoque.domain.model.VerificaEspacoDTO;

public interface EstoqueUsecase {

	public double verificarEstoque(VerificaEspacoDTO verificaDTO);
	
}
