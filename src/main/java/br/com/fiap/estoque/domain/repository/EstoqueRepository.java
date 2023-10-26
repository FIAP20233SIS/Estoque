package br.com.fiap.estoque.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.fiap.estoque.domain.entity.Estoque;
import br.com.fiap.estoque.domain.model.EstoqueResumoDTO;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

//	@Query(   value = "SELECT A.ID_Prateleira  FROM Estoque A INNER JOIN prateleira B on A.ID_Prateleira = B.ID_Prateleira WHERE B.tamanho = '50' AND A.COD_PRODUTO IS NULL",   nativeQuery = true)
	@Query("SELECT e.prateleira.prateleiraId " +
	        "FROM Estoque e " +
	        "JOIN e.prateleira p " +
	        "WHERE p.tamanho = :tamanho " + 
	        " AND e.codProduto IS NULL")
	List<EstoqueResumoDTO> countEstoqueByTamanhoWithEmptyPrateleira(@Param("tamanho") String tamanho);
	
}
