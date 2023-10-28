package br.com.fiap.estoque.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MovimentacaoEstoqueDTO {

	private Integer numRowsUpdated;
	private String codProduto;
	private Long prateleiraId;
	private Double tamanhoPrateleira;
	
}
