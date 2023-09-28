package com.example.estacionamento.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.estacionamento.domain.cliente.Cliente;
import com.example.estacionamento.domain.cliente.ClienteRepository;
import com.example.estacionamento.domain.donoestacionamento.DonoEstacionamento;
import com.example.estacionamento.domain.donoestacionamento.DonoRepository;
import com.example.estacionamento.domain.estacionamento.Estacionamento;
import com.example.estacionamento.domain.estacionamento.EstacionamentoRepository;




@Controller
@RequestMapping("/estacionamento")
public class EstacionamentoController {
	
	@Autowired
	private ClienteRepository repository;
	@Autowired
	private DonoRepository reposito;
	@Autowired
	private EstacionamentoRepository ESTrepository;
	
	@Autowired
    private ClienteRepository clienteRepository; // Supondo que você tenha um repositório de usuários

	
	@GetMapping("/vaga")
    public String exibirFormularioLogin() {
        return "estacionamento/vaga"; // Retorna a página de login
    }
    @PostMapping("/vaga")
    public String fazerLogin(@RequestParam String senha, @RequestParam String email, Model model) {
        // Verifique se o usuário existe no banco de dados
        Cliente usuario = clienteRepository.findBySenhaAndEmail(senha, email);

        if (usuario != null) {
            // Usuário válido, redirecione para a página inicial ou outra página autorizada
        	System.out.println("DEU CERTO");
            return "redirect:/estacionamento/vaga";
        } else {
            // Usuário inválido, mostre uma mensagem de erro
            model.addAttribute("erro", "CPF ou email inválidos");
            return "redirect:/estacionamento";
        }
    }
	@GetMapping
	public String carregaPaginaInicial() {
		return "estacionamento/Inicial";
	}
	
	@GetMapping("/dono")
	public String carregaPaginaEstacionamento() {
		return "estacionamento/dono";
	}
	
	@GetMapping("/CadastroEstacionamento")
	public String carregaPaginaEstacionamento_Cadastro(){
		return "estacionamento/CadastroEstacionamento";
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
	
	@GetMapping("/login_usuario")
	 public String loginPage() {
       return "estacionamento/login_usuario"; 
   }
	
	    @GetMapping("/login-erro")
	    public String loginErro() {
	        return "redirect:/login_usuario?error=true"; // Redirecione para a página de login com mensagem de erro
	    }
	
	@PostMapping
	public String cadastraCliente(CadastroCliente dados, Model model) {
	    var cliente = new Cliente(dados);
	  repository.save(cliente);
	    System.out.println(cliente);
	    return  "redirect:/estacionamento";
	}
	
	@PutMapping
	@Transactional
	public String alteraCliente(alteraCliente dados) {

	    var cliente = repository.getReferenceById(dados.id());
	  cliente.atualizaDados(dados);
	    
	    return  "redirect:/estacionamento/cliente";
	}
	
	@PostMapping("/dono")
	public String cadastraDono(CadastroDonoEstacionamento dados_2,Model model1) {
	    var donoestacionamento = new DonoEstacionamento(dados_2);
	    reposito.save(donoestacionamento);
	    System.out.println(donoestacionamento);

	    return  "redirect:/estacionamento/CadastroEstacionamento";
	}
	@DeleteMapping
	public String removeCliente(Long id) {
	        repository.deleteById(id);
	        return "estacionamento/cliente";
	}
	 
	@PostMapping("/CadastroEstacionamento")
	public String cadastraEstacionamento( CadastroEstacionamento dados_3, Model model_3){
	    var estacionamento = new Estacionamento(dados_3);
	    ESTrepository.save(estacionamento);	
	    return "redirect:/estacionamento";
	}
}
