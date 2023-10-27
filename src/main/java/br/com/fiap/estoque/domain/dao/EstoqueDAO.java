package br.com.fiap.estoque.domain.dao;

import java.math.BigDecimal;

import org.springframework.stereotype.Repository;

import br.com.fiap.estoque.infrastructure.LoggingModule;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class EstoqueDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public Long countEstoqueByTamanhoWithEmptyPrateleira(double tamanho) {
	    String sql = "SELECT COUNT(A.id_estoque) FROM estoque A " +
	                 "INNER JOIN prateleira B ON A.id_prateleira = B.id_prateleira " +
	                 "WHERE B.tamanho = :tamanho AND A.cod_produto IS NULL";

	    BigDecimal count = (BigDecimal ) entityManager
	            .createNativeQuery(sql)
	            .setParameter("tamanho", tamanho)
	            .getSingleResult();
	    
	    LoggingModule.info("aldo: "+count);

	    return count.longValue();
	}


}
