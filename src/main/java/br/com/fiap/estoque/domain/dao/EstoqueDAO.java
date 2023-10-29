package br.com.fiap.estoque.domain.dao;

import java.util.List;

import br.com.fiap.estoque.domain.model.EstoqueDTO;

public interface EstoqueDAO {

	Long countEstoqueByTamanhoWithEmptyPrateleira(double tamanho);
	
	String obterEstoquePorCodigoProduto(String codProd);
	
	int retiradaEstoque(String codProduto);
	int incluirEstoque(String codProduto, Long prateleiraId);
	
	List<EstoqueDTO> obterProdutosNoEstoque();
	
}
