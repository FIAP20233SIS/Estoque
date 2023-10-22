package br.com.fiap.estoque.infrastructure;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.fiap.estoque.infrastructure.exception.RecordNotFoundException;
import jakarta.persistence.EntityNotFoundException;


@ControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * Se em qualquer controller do projeto for lançada uma Exception 'EntityNotFoundException',
	 * o método 'handleError404' será chamado.
	 * 
	 * @return Not Found exception (404).
	 **/
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<?> handleError404() {
		return ResponseEntity.notFound().build();
	}

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<?> handleRecordNotFoundException(RecordNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
