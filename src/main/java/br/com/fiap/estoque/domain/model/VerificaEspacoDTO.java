package br.com.fiap.estoque.domain.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VerificaEspacoDTO(
		@NotBlank
		String codigoBarras,
		
		@NotNull
		@Min(0)
		Integer largura,
		
		@NotNull
		@Min(0)
		Integer altura,
		
		@NotNull
		@Min(0)
		Integer profundidade,
		
		@NotNull
		@Min(0)
		Integer quantidade,
		
		@NotNull
		@Min(0)
		Integer volume
		) {
}

