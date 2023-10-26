package br.com.fiap.estoque.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.fiap.estoque.domain.entity.Estoque;
import br.com.fiap.estoque.domain.model.EstoqueResumoDTO;
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

    @Query("SELECT e.prateleira.prateleiraId " +
        "FROM Estoque e " +
        "INNER JOIN e.prateleira p " +
        "WHERE p.tamanho = :tamanhoParam " +
        "AND e.codProduto IS NULL")
    List<Integer> countEstoqueByTamanhoWithEmptyPrateleira(@Param("tamanhoParam") String tamanho);
}

