package br.com.fiap.estoque.infrastructure.exception;

@SuppressWarnings("serial")
public class RecordNotFoundException extends BusinessException {

	public static final String RECORD_NOT_FOUND_RESOURCE_ID = "error.registro.nao.encontrado"; 

	public RecordNotFoundException() {
		super(RECORD_NOT_FOUND_RESOURCE_ID);
	}

	public RecordNotFoundException(String message, Exception exception) {
		super(RECORD_NOT_FOUND_RESOURCE_ID, message, exception);
	}

	public RecordNotFoundException(String message) {
		super(RECORD_NOT_FOUND_RESOURCE_ID, message);
	}

	public RecordNotFoundException(Exception exception) {
		super(RECORD_NOT_FOUND_RESOURCE_ID, exception);
	}
	
}
