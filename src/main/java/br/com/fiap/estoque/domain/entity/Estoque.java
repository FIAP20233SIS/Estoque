package br.com.fiap.estoque.domain.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_ESTOQUE")
	private Long estoqueID;

    @ManyToOne
    @JoinColumn(name = "ID_PRATELEIRA", referencedColumnName = "ID_PRATELEIRA")
    private Prateleira prateleira;

    @Column(name = "COD_PRODUTO")
    private String codProduto;
    private Date dataEstoque;

}
