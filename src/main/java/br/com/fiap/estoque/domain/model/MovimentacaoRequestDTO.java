package br.com.fiap.estoque.domain.model;

import br.com.fiap.estoque.enums.TipoMovimentacao;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MovimentacaoRequestDTO(
		@NotBlank
		String codigoBarras,
		
		@NotNull
		@Min(0)
		Double largura,
		
		@NotNull
		@Min(0)
		Double altura,
		
		@NotNull
		@Min(0)
		Double profundidade,
				
		@NotNull
		TipoMovimentacao tipoMovimentacao
	) {
}

