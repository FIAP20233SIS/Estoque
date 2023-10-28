package br.com.fiap.estoque.domain.dao;

import java.math.BigDecimal;
import java.util.List;

public interface PrateleiraDAO {

	List<BigDecimal> obterPrateleirasVaziasPorTamanho(Double tamanho);
	
}
