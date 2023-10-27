package br.com.fiap.estoque.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.estoque.controller.EstoqueController;
import br.com.fiap.estoque.domain.model.VerificaEspacoDTO;
import br.com.fiap.estoque.domain.model.VerificaEspacoResponseDTO;
import br.com.fiap.estoque.domain.service.EstoqueImpl;
import br.com.fiap.estoque.infrastructure.exception.BusinessException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/estoque")
public class EstoqueControllerImpl implements EstoqueController {
	
	@Autowired
	private EstoqueImpl estoqueService;
	
	@PostMapping("/verificaespaco")
	public ResponseEntity<VerificaEspacoResponseDTO> verificaEspacoEstoque(@Valid @RequestBody VerificaEspacoDTO estoqueDTO) {
		var estoque = estoqueService.verificarEstoque(estoqueDTO);
		
		return ResponseEntity.ok(estoque);
	}
	
	@PostMapping("/movimentar")
	public ResponseEntity<String> movimentarEstoque(@Valid @RequestBody VerificaEspacoDTO model) throws BusinessException {
		String produtoIncluido = estoqueService.movimentarEstoque(model);
		
		return ResponseEntity.ok("Produto incluído na prateleira: " + produtoIncluido);
	}
	
}
