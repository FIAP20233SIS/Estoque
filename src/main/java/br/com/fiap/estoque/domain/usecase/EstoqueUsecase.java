package br.com.fiap.estoque.domain.usecase;

import br.com.fiap.estoque.domain.model.VerificaEspacoDTO;
import br.com.fiap.estoque.domain.model.VerificaEspacoResponseDTO;

public interface EstoqueUsecase {

	public VerificaEspacoResponseDTO verificarEstoque(VerificaEspacoDTO verificaDTO);
	
}
