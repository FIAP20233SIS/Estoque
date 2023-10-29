package br.com.fiap.estoque.domain.model;

import java.math.BigDecimal;
import java.util.Date;

public record EstoqueDTO(Long estoqueID, Long prateleiraId, String codProduto, Date dataEstoque) {

    public static EstoqueDTO from(Object[] obj) {
        return new EstoqueDTO(
            ((BigDecimal) obj[0]).longValue(),
            ((BigDecimal) obj[1]).longValue(),
            (String) obj[2],
            (Date) obj[3]
        );
    }
}