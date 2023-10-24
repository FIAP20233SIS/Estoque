package br.com.fiap.estoque.domain.entity;

import java.util.Date;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Entity
@Table(name = "Estoque")
public class Estoque {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long prateleiraId;
	private String codProduto;
	private Date dataEstoque;

}
