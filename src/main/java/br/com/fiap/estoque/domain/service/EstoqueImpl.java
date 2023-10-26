package br.com.fiap.estoque.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.estoque.domain.dao.EstoqueDAO;
import br.com.fiap.estoque.domain.model.EstoqueResumoDTO;
import br.com.fiap.estoque.domain.model.VerificaEspacoDTO;
import br.com.fiap.estoque.domain.model.VerificaEspacoResponseDTO;
import br.com.fiap.estoque.domain.repository.EstoqueRepository;
import br.com.fiap.estoque.domain.usecase.EstoqueUsecase;
import br.com.fiap.estoque.infrastructure.LoggingModule;
import br.com.fiap.estoque.utils.Calculos;

@Service
public class EstoqueImpl implements EstoqueUsecase {

	@Autowired
	private EstoqueRepository estoqueRepository;
	
	@Autowired
	private EstoqueDAO estoqueDAO;

	@Override
	public VerificaEspacoResponseDTO verificarEstoque(VerificaEspacoDTO verificaDTO) {
		LoggingModule.info("iniciando método: verificarEstoque(verificaDTO)]");
		
		Double volume = Calculos.calcularVolume(verificaDTO.largura(), verificaDTO.altura(), verificaDTO.profundidade());
		LoggingModule.info("Volume no service: " + volume.toString());

//		List<Integer> qtdeLugaresDisponiveis = estoqueRepository.countEstoqueByTamanhoWithEmptyPrateleira(volume.toString());
		
		List<Long> qtdeLugaresDisponiveis = estoqueDAO.countEstoqueByTamanhoWithEmptyPrateleira(volume.toString());
		
		
		LoggingModule.info("Qunatidade de lugares encontrados: " + qtdeLugaresDisponiveis.size());
		LoggingModule.info("finalizando método: verificarEstoque(verificaDTO)]");
		return new VerificaEspacoResponseDTO(qtdeLugaresDisponiveis.size());
	}

}
