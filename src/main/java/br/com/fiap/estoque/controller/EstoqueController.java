package br.com.fiap.estoque.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.estoque.domain.model.VerificaEspacoDTO;
import br.com.fiap.estoque.domain.model.VerificaEspacoResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/estoque")
public interface EstoqueController {

	@Operation(summary = "Estoque API - Digital One Platform", description = "Returns a OK or NOK Login", tags = {
			"Estoque API" })
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = ResponseEntity.class))),
			@ApiResponse(responseCode = "400", description = "Invalid Login Data supplied", content = @Content),
			@ApiResponse(responseCode = "401", description = "Invalid Authentication supplied", content = @Content),
			@ApiResponse(responseCode = "403", description = "Invalid Authorization supplied", content = @Content),
			@ApiResponse(responseCode = "404", description = "Login or Password not found", content = @Content) })
	@PostMapping(value = "/", consumes = "multipart/form-data")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<VerificaEspacoResponseDTO> verificaEspacoEstoque(
			@Valid @RequestBody VerificaEspacoDTO estoqueDTO);

}
