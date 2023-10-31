package br.com.fiap.estoque.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.estoque.domain.model.EstoqueDTO;
import br.com.fiap.estoque.domain.model.MovimentacaoEstoqueDTO;
import br.com.fiap.estoque.domain.model.MovimentacaoRequestDTO;
import br.com.fiap.estoque.domain.model.VerificaEspacoResponseDTO;
import br.com.fiap.estoque.domain.model.VerificaEstoqueDTO;
import br.com.fiap.estoque.domain.model.VerificaProdutoEstoqueDTO;
import br.com.fiap.estoque.infrastructure.exception.BusinessException;
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

	@Operation(summary = "Estoque API - Verifica o espaço no estoque.",
			description = "Vai retornar o número de espaços disponíveis no estoque para a largura, altura e profundidade informada.\nRetornará 0 caso não tenha nenhuma",
			tags = { "Estoque API" })
	@ApiResponses(value = {
	@ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = ResponseEntity.class))),
	@ApiResponse(responseCode = "400", description = "Invalid Login Data supplied", content = @Content),
	@ApiResponse(responseCode = "401", description = "Invalid Authentication supplied", content = @Content),
	@ApiResponse(responseCode = "403", description = "Invalid Authorization supplied", content = @Content),
	@ApiResponse(responseCode = "404", description = "Login or Password not found", content = @Content) })
	@PostMapping(value = "/", consumes = "multipart/form-data")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<VerificaEspacoResponseDTO> verificaEspacoEstoque(@Valid @RequestBody VerificaEstoqueDTO estoqueDTO);
	
	@Operation(summary = "Estoque API - Realiza as movimentações no estoque.",
			description = "Realiza a retirada ou inclusão no estoque.",
			tags = { "Estoque API" })
	public ResponseEntity<MovimentacaoEstoqueDTO> movimentarEstoque(@Valid @RequestBody MovimentacaoRequestDTO estoqueDTO) throws BusinessException;
	
	@Operation(summary = "Estoque API - Verifica se um produto já está no estoque.",
			description = "A partir de um código de barras informado via URL, o endpoint fará uma verificação no banco de dados para ver se já tem um produto cadastrado com o código informado.",
			tags = { "Estoque API" })
	public ResponseEntity<VerificaProdutoEstoqueDTO> verificaProdutoEstoque(@PathVariable String codBarras) throws BusinessException;

	@Operation(summary = "Estoque API - Lista todos os produtos do estoque.",
			description = "Lista todos os produtos do estoque.",
			tags = { "Estoque API" })
	public ResponseEntity<List<EstoqueDTO>> obterProdutoNoEstoque() throws BusinessException;

}
