package br.com.fiap.estoque.domain.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class EstoqueDAOImpl implements EstoqueDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Long countEstoqueByTamanhoWithEmptyPrateleira(double tamanho) {
		StringBuilder sb = new StringBuilder();

		sb.append("SELECT COUNT(A.id_estoque) FROM estoque A ")
		.append("INNER JOIN prateleira B ON A.id_prateleira = B.id_prateleira ")
		.append("WHERE B.tamanho < :tamanho AND A.cod_produto IS NULL");

		String sql = sb.toString();

		BigDecimal count = (BigDecimal) entityManager
				.createNativeQuery(sql)
				.setParameter("tamanho", tamanho)
				.getSingleResult();

		return count.longValue();
	}
	
	@Override
	public String obterEstoquePorCodigoProduto(String codProd) {
	    String sql = "SELECT E.COD_PRODUTO " +
	                 "FROM ESTOQUE E " +
	                 "WHERE UPPER(E.COD_PRODUTO) = :codProd";
	
		List<?> results = entityManager
				.createNativeQuery(sql)
				.setParameter("codProd", codProd.toUpperCase())
				.getResultList();

		if (results.isEmpty()) {
			return null;
		} else {
			return (String) results.get(0);
		}
	}

	@Override
	@Transactional
	public int retiradaEstoque(String codProduto) {
		StringBuilder sqlBuilder = new StringBuilder();

		sqlBuilder.append("UPDATE estoque ")
		          .append("SET cod_produto = NULL, ")
		          .append("data_estoque = NULL ")
		          .append("WHERE cod_produto = :codProduto");

		String sql = sqlBuilder.toString();
		
		return entityManager
				.createNativeQuery(sql)
				.setParameter("codProduto", codProduto)
				.executeUpdate();
	}

	@Override
	@Transactional
	public int incluirEstoque(String codProduto, Long prateleiraId) {
		StringBuilder sqlBuilder = new StringBuilder();

		sqlBuilder.append("UPDATE estoque ")
		          .append("SET cod_produto = :codProduto, ")
		          .append("data_estoque = SYSDATE ")
		          .append("WHERE id_prateleira  = :prateleiraId");

		String sql = sqlBuilder.toString();
		
		return entityManager
				.createNativeQuery(sql)
				.setParameter("codProduto", codProduto)
				.setParameter("prateleiraId", prateleiraId)
				.executeUpdate();
	}
	
}
