package com.example.estacionamento.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/estacionamento")
public class EstacionamentoController {
	
	@GetMapping
	public String carregaPaginaFormulario() {
	        return "estacionamento/cliente";
	    }

	  @PostMapping
	    public String cadastraCliente() {
	        return "estacionamento/cliente";
	    }

}
