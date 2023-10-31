package br.com.fiap.estoque.domain.usecase;

import java.util.List;

import br.com.fiap.estoque.domain.model.EstoqueDTO;
import br.com.fiap.estoque.domain.model.MovimentacaoEstoqueDTO;
import br.com.fiap.estoque.domain.model.MovimentacaoRequestDTO;
import br.com.fiap.estoque.domain.model.VerificaEspacoResponseDTO;
import br.com.fiap.estoque.domain.model.VerificaEstoqueDTO;
import br.com.fiap.estoque.infrastructure.exception.BusinessException;
import br.com.fiap.estoque.infrastructure.exception.RecordNotFoundException;

public interface EstoqueUsecase {

	public VerificaEspacoResponseDTO verificarEstoque(VerificaEstoqueDTO verificaDTO);
	public MovimentacaoEstoqueDTO movimentarEstoque(MovimentacaoRequestDTO verificaDTO) throws BusinessException;
	public boolean verificaProdutoNoEstoque(String codBarras, boolean throwEx) throws BusinessException;
	public List<EstoqueDTO> obterProdutosNoEstoque() throws RecordNotFoundException;
	
}
