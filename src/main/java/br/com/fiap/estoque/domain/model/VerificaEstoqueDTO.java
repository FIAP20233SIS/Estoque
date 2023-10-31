package br.com.fiap.estoque.domain.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record VerificaEstoqueDTO(
		
		@NotNull
		@Min(0)
		Double largura,
		
		@NotNull
		@Min(0)
		Double altura,
		
		@NotNull
		@Min(0)
		Double profundidade

	) {
}
