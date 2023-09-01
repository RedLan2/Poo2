package com.example.estacionamento.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.estacionamento.domain.cliente.Cliente;


@Controller
@RequestMapping("/estacionamento")
public class EstacionamentoController {
	
	private List<Cliente> clientes= new ArrayList<>();
	@GetMapping
	public String carregaPaginaFormulario() {
		
	        return "estacionamento/cliente";
	    }
	@PostMapping
	public String cadastraCliente(CadastroCliente dados, Model model) {
	    var cliente = new Cliente(dados);
	    clientes.add(cliente); // Adicione o cliente à lista de clientes

	    System.out.println(clientes); // Agora imprima a lista de clientes
	    model.addAttribute("lista", clientes);

	    return "estacionamento/listagem";
	}


	@GetMapping("/listagem")
	public String carregaPaginaListagem(Model model) {
		model.addAttribute( "lista", clientes);

		return "estacionamento/listagem";
	}
		  



}
