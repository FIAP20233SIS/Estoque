package br.com.fiap.estoque.domain.validations;

import org.springframework.stereotype.Component;

import br.com.fiap.estoque.domain.model.MovimentacaoRequestDTO;
import br.com.fiap.estoque.infrastructure.exception.BusinessException;
import br.com.fiap.estoque.utils.Calculos;

@Component
public class StockVolumeMovementValidator implements StockValidator {

	@Override
	public void validate(MovimentacaoRequestDTO model) throws BusinessException {

		Double volume = Calculos.calcularVolume(model.largura(), model.altura(), model.profundidade());
		if (volume.intValue() == 0) {
			throw new BusinessException("Volume igual à 0 não é permitido.", "volume.error");
		}
		
	}
	
}
