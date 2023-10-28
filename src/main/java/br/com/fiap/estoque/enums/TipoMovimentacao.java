package br.com.fiap.estoque.enums;

import br.com.fiap.estoque.infrastructure.LoggingModule;

public enum TipoMovimentacao {
	
	RETIRADA(0),
	INCLUSAO(1);

	private final int type;

	TipoMovimentacao(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}

	public static TipoMovimentacao fromValue(int value) {
		for (TipoMovimentacao type : TipoMovimentacao.values()) {
			if (type.getType() == value) {
				return type;
			}
		}

		LoggingModule.error("Valor inválido para TipoMovimentacao: " + value);
		throw new IllegalArgumentException("Valor inválido para TipoMovimentacao: " + value);
	}

}
