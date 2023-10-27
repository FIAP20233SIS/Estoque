package br.com.fiap.estoque.domain.dao;

public interface EstoqueDAO {

	Long countEstoqueByTamanhoWithEmptyPrateleira(double tamanho);
	
}
