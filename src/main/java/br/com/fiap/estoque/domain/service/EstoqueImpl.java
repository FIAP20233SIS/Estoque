package br.com.fiap.estoque.domain.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.estoque.domain.dao.EstoqueDAO;
import br.com.fiap.estoque.domain.model.VerificaEspacoDTO;
import br.com.fiap.estoque.domain.model.VerificaEspacoResponseDTO;
import br.com.fiap.estoque.domain.usecase.EstoqueUsecase;
import br.com.fiap.estoque.infrastructure.LoggingModule;
import br.com.fiap.estoque.infrastructure.exception.BusinessException;
import br.com.fiap.estoque.utils.Calculos;

@Service
public class EstoqueImpl implements EstoqueUsecase {
	
	@Autowired
	private EstoqueDAO estoqueDAO;

	@Override
	public VerificaEspacoResponseDTO verificarEstoque(VerificaEspacoDTO verificaDTO) {
		LoggingModule.info("iniciando método: verificarEstoque(verificaDTO)]");
		
		Double volume = Calculos.calcularVolume(verificaDTO.largura(), verificaDTO.altura(), verificaDTO.profundidade());
		LoggingModule.info("Volume no service: " + volume.toString());

		Long qtdeLugaresDisponiveis = estoqueDAO.countEstoqueByTamanhoWithEmptyPrateleira(volume);
		LoggingModule.info("Quantidade de lugares encontrados: " + qtdeLugaresDisponiveis);

		LoggingModule.info("finalizando método: verificarEstoque(verificaDTO)]");
		return new VerificaEspacoResponseDTO(qtdeLugaresDisponiveis);
	}
	
	public String movimentarEstoque(VerificaEspacoDTO model) throws BusinessException {
		LoggingModule.info("iniciando método: movimentarEstoque(model)]");
		
		var estoque = this.verificarEstoque(model);
		
		if (estoque.lugaresDisponiveis().intValue() == 0) {
			LoggingModule.info("Não há espaço suficiente para esse produto.");
			throw new BusinessException("Não há espaço suficiente para esse produto.");
		}
		
		Double volume = Calculos.calcularVolume(model.largura(), model.altura(), model.profundidade());
		if (volume.intValue() == 0) {
			throw new BusinessException("Volume igual à 0 não é permitido.", "volume.error");
		}

        List<Double> values = List.of(model.largura(), model.altura(), model.profundidade());
        Integer tamanho = Calculos.verificaTamanho(values);
        
        Map<Integer, String> sizeMap = sizeMapper();
        
        String produtoIncluido = sizeMap.getOrDefault(tamanho, "Não cabe");
		
		LoggingModule.info("finalizando método: movimentarEstoque(model)]");
        return produtoIncluido;
	}
	
    public static Map<Integer, String> sizeMapper() {
        Map<Integer, String> messageMap = new HashMap<>();
        
        messageMap.put(0, "Produto Pequeno");
        messageMap.put(1, "Produto Médio");
        messageMap.put(2, "Produto Grande");
        
        return messageMap;
    }

}
