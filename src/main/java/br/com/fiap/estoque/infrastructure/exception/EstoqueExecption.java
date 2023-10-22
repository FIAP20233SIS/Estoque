package br.com.fiap.estoque.infrastructure.exception;

@SuppressWarnings("serial")
public class EstoqueExecption extends Exception {

	public EstoqueExecption() {
		super();
	}
	
	public EstoqueExecption(String message) {
		super(message);
	}
	
}
