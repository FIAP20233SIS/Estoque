package br.com.fiap.estoque.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.estoque.controller.EstoqueController;
import br.com.fiap.estoque.domain.model.MovimentacaoEstoqueDTO;
import br.com.fiap.estoque.domain.model.VerificaEspacoDTO;
import br.com.fiap.estoque.domain.model.VerificaEspacoResponseDTO;
import br.com.fiap.estoque.domain.model.VerificaProdutoEstoqueDTO;
import br.com.fiap.estoque.domain.service.EstoqueImpl;
import br.com.fiap.estoque.infrastructure.exception.BusinessException;
import br.com.fiap.estoque.infrastructure.exception.RecordNotFoundException;
import br.com.fiap.estoque.utils.Providers;
import jakarta.transaction.Transactional;
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
	
	@GetMapping("/verificaproduto/{codBarras}")
	public ResponseEntity<VerificaProdutoEstoqueDTO> verificaProdutoEstoque(@PathVariable String codBarras) throws RecordNotFoundException {
		boolean hasProdutoInStock = estoqueService.verificaProdutoNoEstoque(codBarras, false);

		return ResponseEntity.ok(new VerificaProdutoEstoqueDTO(codBarras, hasProdutoInStock, Providers.getProductInStockMessage(hasProdutoInStock, codBarras)));
	}
	
	@PostMapping("/movimentar")
	@Transactional
	public ResponseEntity<MovimentacaoEstoqueDTO> movimentarEstoque(@Valid @RequestBody VerificaEspacoDTO model) throws BusinessException {
		MovimentacaoEstoqueDTO produtoIncluido = estoqueService.movimentarEstoque(model);
		
		return ResponseEntity.ok(produtoIncluido);
	}
	
}
