package br.com.fiap.estoque.domain.model;

public record VerificaProdutoEstoqueDTO(
		String codProduto,
		
		boolean isInStock,
		
		String message
		) {

}
