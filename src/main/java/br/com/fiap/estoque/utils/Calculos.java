package br.com.fiap.estoque.utils;

import br.com.fiap.estoque.infrastructure.LoggingModule;

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
		var volume = largura * altura * profundidade;
		
		LoggingModule.info("Volume calculado:" + volume);
		
		return volume;
	}
	
}
