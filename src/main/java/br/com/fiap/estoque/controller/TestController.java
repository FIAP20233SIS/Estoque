package br.com.fiap.estoque.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class TestController {

	@GetMapping("/mensagem")
	public String getMensagem() {
		return "[TESTE] - API está funcionando!";
	}

}
