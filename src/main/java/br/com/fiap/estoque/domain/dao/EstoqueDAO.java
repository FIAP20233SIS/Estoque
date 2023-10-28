package br.com.fiap.estoque.domain.dao;

public interface EstoqueDAO {

	Long countEstoqueByTamanhoWithEmptyPrateleira(double tamanho);
	
	int retiradaEstoque(String codProduto);
	int incluirEstoque(String codProduto, Long prateleiraId);
	
}
