package br.com.fiap.estoque.domain.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "Estoque")
@Table(name = "Estoque")
public class Estoque {

	private Long prateleiraId;
	private String codProduto;
	private Date dataEstoque;
	
}
