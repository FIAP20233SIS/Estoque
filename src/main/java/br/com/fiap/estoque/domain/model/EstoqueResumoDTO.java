package br.com.fiap.estoque.domain.model;

public class EstoqueResumoDTO {
    private String tamanho;
    private Long count;

    public EstoqueResumoDTO(String tamanho, Long count) {
        this.tamanho = tamanho;
        this.count = count;
    }

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

}
