package br.com.fiap.estoque.domain.model;

public class EstoqueResumoDTO {

	private Long prateleiraId;
	private String tamanhoParam;

	public EstoqueResumoDTO() {
	}

	public Long getPrateleiraId() {
		return prateleiraId;
	}

	public void setPrateleiraId(Long prateleiraId) {
		this.prateleiraId = prateleiraId;
	}

	public String getTamanhoParam() {
		return tamanhoParam;
	}

	public void setTamanhoParam(String tamanhoParam) {
		this.tamanhoParam = tamanhoParam;
	}

}
