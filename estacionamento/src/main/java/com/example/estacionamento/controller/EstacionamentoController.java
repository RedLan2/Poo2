package com.example.estacionamento.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.estacionamento.domain.cliente.Cliente;
import com.example.estacionamento.domain.cliente.ClienteRepository;
import com.example.estacionamento.domain.donoestacionamento.DonoEstacionamento;
import com.example.estacionamento.domain.donoestacionamento.DonoRepository;




@Controller
@RequestMapping("/estacionamento")
public class EstacionamentoController {
	
	@Autowired
	private ClienteRepository repository;
	@Autowired
	private DonoRepository reposito;
	
	@GetMapping
	public String carregaPaginaInicial() {
		return "estacionamento/Inicial";
	}
	
	@GetMapping("/dono")
	public String carregaPaginaEstacionamento() {
		return "estacionamento/dono";
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
	
	@PostMapping("/dono")
	public String cadastraDono(CadastroDonoEstacionamento dados_2,Model model1) {
	    var donoestacionamento = new DonoEstacionamento(dados_2);
	    reposito.save(donoestacionamento);
	    System.out.println(donoestacionamento);

	    return  "estacionamento/dono";
	}
	
	 
	    
	}

