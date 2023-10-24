package br.com.fiap.estoque.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.fiap.estoque.domain.entity.Estoque;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
/**
	@Query("SELECT e.shelf FROM Estoque e WHERE e.isEmpty = true")
	Integer findEmptyShelf();
*/
}
