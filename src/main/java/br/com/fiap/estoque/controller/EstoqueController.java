package br.com.fiap.estoque.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.estoque.domain.model.VerificaEspacoDTO;
import br.com.fiap.estoque.domain.model.VerificaEspacoResponseDTO;
import br.com.fiap.estoque.domain.service.EstoqueImpl;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/estoque")
public class EstoqueController {
	
	@Autowired
	private EstoqueImpl estoqueService;

	@PostMapping("/verificaespaco")
	public ResponseEntity<VerificaEspacoResponseDTO> verificaEspacoEstoque(@Valid @RequestBody VerificaEspacoDTO estoqueDTO) {
		double teste = estoqueService.verificarEstoque(estoqueDTO);
		
		var testeResponse = new VerificaEspacoResponseDTO(Integer.valueOf(1));
		
		System.out.println(estoqueDTO);
		return ResponseEntity.ok(testeResponse);
	}
	
}
