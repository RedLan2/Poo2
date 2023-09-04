package com.example.estacionamento.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.estacionamento.domain.cliente.Cliente;
import com.example.estacionamento.domain.cliente.ClienteRepository;


@Controller
@RequestMapping("/estacionamento")
public class EstacionamentoController {
	
	@Autowired
	private ClienteRepository repository;
	
	@GetMapping
	public String carregaPaginaInicial() {
		return "estacionamento/Inicial";
	}
	
	@GetMapping("/cliente")
	public String carregaPaginaFormulario() {
	        return "estacionamento/cliente";
	    }
	
	@GetMapping("/listagem")
	public String carregaPaginaListagem(Model model) {
		model.addAttribute("lista", repository.findAll());

		return "estacionamento/listagem";
	}
	
	@PostMapping
	public String cadastraCliente(CadastroCliente dados, Model model) {
	    var cliente = new Cliente(dados);
	  repository.save(cliente);
	    System.out.println(cliente);
	    return  "redirect:/estacionamento/listagem";
	}


  



}
