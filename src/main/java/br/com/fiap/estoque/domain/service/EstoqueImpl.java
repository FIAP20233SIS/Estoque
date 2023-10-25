package br.com.fiap.estoque.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.estoque.domain.model.VerificaEspacoDTO;
import br.com.fiap.estoque.domain.repository.EstoqueRepository;
import br.com.fiap.estoque.domain.usecase.EstoqueUsecase;
import br.com.fiap.estoque.infrastructure.LoggingModule;

@Service
public class EstoqueImpl implements EstoqueUsecase {
	
	@Autowired
	private EstoqueRepository estoqueRepository;

	@Override
	public double verificarEstoque(VerificaEspacoDTO verificaDTO) {
		LoggingModule.info("iniciando método: verificarEstoque(verificaDTO)]");
		
		double volume = EstoqueImpl.calcularVolume(verificaDTO.largura(), verificaDTO.altura(), verificaDTO.profundidade());
		System.out.println(volume);
		
		LoggingModule.info("finalizando método: verificarEstoque(verificaDTO)]");
		return volume;
	}

    /**
     * Calcula o volume de um retângulo com base em sua largura, altura e profundidade.
     * 
     * @param largura A largura do retângulo.
     * @param altura A altura do retângulo.
     * @param profundidade A profundidade do retângulo.
     * @return O volume calculado.
     */
    private static double calcularVolume(double largura, double altura, double profundidade) {
        return largura * altura * profundidade;
    }
	
}
