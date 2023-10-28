package br.com.fiap.estoque.domain.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class PrateleiraDAOImpl implements PrateleiraDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<BigDecimal> obterPrateleirasVaziasPorTamanho(Double tamanho) {
		String sql = "SELECT A.id_prateleira " +
	             "FROM estoque A " +
	             "INNER JOIN prateleira B "+ 
	             "ON A.id_prateleira = B.id_prateleira " +
	             "WHERE B.tamanho = :tamanho " +
	             "AND A.cod_produto IS NULL";

		@SuppressWarnings("unchecked")
		List<BigDecimal> prateleiras = entityManager
				.createNativeQuery(sql)
				.setParameter("tamanho", tamanho)
				.getResultList();

		return prateleiras;
	}
}
