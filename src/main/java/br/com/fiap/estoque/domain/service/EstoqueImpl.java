package br.com.fiap.estoque.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.estoque.domain.model.EstoqueResumoDTO;
import br.com.fiap.estoque.domain.model.VerificaEspacoDTO;
import br.com.fiap.estoque.domain.model.VerificaEspacoResponseDTO;
import br.com.fiap.estoque.domain.repository.EstoqueRepository;
import br.com.fiap.estoque.domain.usecase.EstoqueUsecase;
import br.com.fiap.estoque.infrastructure.LoggingModule;

@Service
public class EstoqueImpl implements EstoqueUsecase {

	@Autowired
	private EstoqueRepository estoqueRepository;

	@Override
	public VerificaEspacoResponseDTO verificarEstoque(VerificaEspacoDTO verificaDTO) {
		LoggingModule.info("iniciando método: verificarEstoque(verificaDTO)]");

		List<EstoqueResumoDTO> qtdeLugaresDisponiveis = estoqueRepository.countEstoqueByTamanhoWithEmptyPrateleira();

		LoggingModule.info("finalizando método: verificarEstoque(verificaDTO)]");
		return new VerificaEspacoResponseDTO(qtdeLugaresDisponiveis.size());
	}

}
