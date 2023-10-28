package br.com.fiap.estoque.domain.dao;

public interface EstoqueDAO {

	Long countEstoqueByTamanhoWithEmptyPrateleira(double tamanho);
	
	String obterEstoquePorCodigoProduto(String codProd);
	
	int retiradaEstoque(String codProduto);
	int incluirEstoque(String codProduto, Long prateleiraId);
	
}
