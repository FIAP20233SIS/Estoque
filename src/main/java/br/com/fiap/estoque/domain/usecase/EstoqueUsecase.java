package br.com.fiap.estoque.domain.usecase;

import java.util.List;

import br.com.fiap.estoque.domain.model.EstoqueDTO;
import br.com.fiap.estoque.domain.model.MovimentacaoEstoqueDTO;
import br.com.fiap.estoque.domain.model.VerificaEspacoDTO;
import br.com.fiap.estoque.domain.model.VerificaEspacoResponseDTO;
import br.com.fiap.estoque.infrastructure.exception.BusinessException;
import br.com.fiap.estoque.infrastructure.exception.RecordNotFoundException;

public interface EstoqueUsecase {

	public VerificaEspacoResponseDTO verificarEstoque(VerificaEspacoDTO verificaDTO);
	public MovimentacaoEstoqueDTO movimentarEstoque(VerificaEspacoDTO verificaDTO) throws BusinessException;
	public boolean verificaProdutoNoEstoque(String codBarras, boolean throwEx) throws BusinessException;
	public List<EstoqueDTO> obterProdutosNoEstoque() throws RecordNotFoundException;
	
}
