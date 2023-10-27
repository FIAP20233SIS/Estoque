package br.com.fiap.estoque.enums;

import br.com.fiap.estoque.infrastructure.LoggingModule;

public enum ProductSize {
	NAO_CABE(-1, "Não cabe"),
    PEQUENO(0, "Produto Pequeno"),
    MEDIO(1, "Produto Médio"),
    GRANDE(2, "Produto Grande");

    private final int value;
    private final String description;

    ProductSize(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public static ProductSize fromValue(int value) {
        for (ProductSize size : ProductSize.values()) {
            if (size.getValue() == value) {
                return size;
            }
        }

        LoggingModule.error("Valor inválido para ProductSize: " + value);
        throw new IllegalArgumentException("Valor inválido para ProductSize: " + value);
    }

    public static String getDescriptionByValue(int value) {
        return fromValue(value).getDescription();
    }
}
