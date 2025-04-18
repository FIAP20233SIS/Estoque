package br.com.fiap.estoque.utils;

import java.util.List;

import br.com.fiap.estoque.domain.model.MovimentacaoRequestDTO;

public class Providers {
	
	/**
	 * Cria e retorna uma lista contendo os valores dos lados (largura, altura, profundidade)
	 * de um objeto {@code VerificaEspacoDTO}.
	 * 
	 * @param model O objeto {@code VerificaEspacoDTO} a partir do qual os valores dos lados serão obtidos.
	 *              Não deve ser {@code null}.
	 * @return Uma lista de {@code Double} contendo, nesta ordem, a largura, altura e profundidade
	 *         extraídas do objeto {@code VerificaEspacoDTO} fornecido.
	 */
	public static List<Double> createSideSizeValuesList(MovimentacaoRequestDTO model) {
	    return List.of(model.largura(), model.altura(), model.profundidade());
	}
	
	public static String getProductInStockMessage(boolean hasProdutoInStock, String codBarras) {
		return hasProdutoInStock
				? "Já existe um produto com o código de barras " + codBarras + " no estoque."
				: "Produto não está no estoque.";
	}

}
