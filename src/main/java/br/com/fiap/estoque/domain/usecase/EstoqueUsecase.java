package br.com.fiap.estoque.domain.usecase;

import br.com.fiap.estoque.domain.model.MovimentacaoEstoqueDTO;
import br.com.fiap.estoque.domain.model.VerificaEspacoDTO;
import br.com.fiap.estoque.domain.model.VerificaEspacoResponseDTO;
import br.com.fiap.estoque.infrastructure.exception.BusinessException;

public interface EstoqueUsecase {

	public VerificaEspacoResponseDTO verificarEstoque(VerificaEspacoDTO verificaDTO);
	public MovimentacaoEstoqueDTO movimentarEstoque(VerificaEspacoDTO verificaDTO) throws BusinessException;
	
}
