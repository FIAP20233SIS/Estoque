package br.com.fiap.estoque.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.estoque.domain.entity.Estoque;
import br.com.fiap.estoque.domain.model.EstoqueResumoDTO;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

	@Query("SELECT p.tamanho, COUNT(DISTINCT e.prateleira.prateleiraId) "
			+ "FROM Estoque e "
			+ "JOIN e.prateleira p "
			+ "WHERE e.codProduto IS NULL "
			+ "GROUP BY p.tamanho")
	List<EstoqueResumoDTO> countEstoqueByTamanhoWithEmptyPrateleira();


}
