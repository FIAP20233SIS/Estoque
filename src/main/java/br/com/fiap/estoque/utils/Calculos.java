package br.com.fiap.estoque.utils;

import java.util.List;

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
	public static Double calcularVolume(double largura, double altura, double profundidade) {
		var volume = largura * altura * profundidade;
		
		LoggingModule.info("Volume calculado:" + volume);
		
		return volume;
	}
	
    public static int verificaTamanho(List<Double> values) {
        int count = 0;
        int tamanho = -1; // Valor padrão para "Não cabe"
        for (Double value : values) {
            if (value < 50) {
                count++;
                if (count == 3) {
                    tamanho = 0; // Tamanho pequeno
                    break;
                }
            } else if (value < 100) {
                count++;
                if (count == 3) {
                    tamanho = 1; // Tamanho médio
                    break;
                }
            } else if (value < 150) {
                count++;
                if (count == 3) {
                    tamanho = 2; // Tamanho grande
                    break;
                }
            }
        }
        return tamanho;
    }
	
}
