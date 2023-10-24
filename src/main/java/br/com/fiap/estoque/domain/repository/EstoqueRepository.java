package br.com.fiap.estoque.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.estoque.domain.entity.Estoque;
import br.com.fiap.estoque.domain.entity.Prateleira;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

}
