package br.com.fiap.estoque.domain.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class EstoqueDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Long> countEstoqueByTamanhoWithEmptyPrateleira(String tamanho) {
		String sql = "SELECT A.id_prateleira " + "FROM estoque A "
				+ "INNER JOIN prateleira B ON A.id_prateleira = B.id_prateleira "
				+ "WHERE B.tamanho = :tamanho AND A.cod_produto IS NULL";

		return entityManager.createNativeQuery(sql).setParameter("tamanho", tamanho).getResultList();
	}

}
