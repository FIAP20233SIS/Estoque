package br.com.fiap.estoque.utils;

public class Calculos {

	/**
	 * Calcula o volume de um retângulo com base em sua largura, altura e
	 * profundidade.
	 * 
	 * @param largura      A largura do retângulo.
	 * @param altura       A altura do retângulo.
	 * @param profundidade A profundidade do retângulo.
	 * @return O volume calculado.
	 */
	public static double calcularVolume(double largura, double altura, double profundidade) {
		return largura * altura * profundidade;
	}
	
}
