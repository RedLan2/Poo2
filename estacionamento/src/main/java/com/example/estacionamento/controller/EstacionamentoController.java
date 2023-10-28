package com.example.estacionamento.controller;



import java.net.http.HttpRequest;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.estacionamento.domain.cliente.Cliente;
import com.example.estacionamento.domain.cliente.ClienteRepository;
import com.example.estacionamento.domain.cliente.Veiculo;
import com.example.estacionamento.domain.cliente.VeiculoRepository;
import com.example.estacionamento.domain.donoestacionamento.DonoEstacionamento;
import com.example.estacionamento.domain.donoestacionamento.DonoRepository;
import com.example.estacionamento.domain.estacionamento.Estacionamento;
import com.example.estacionamento.domain.estacionamento.EstacionamentoRepository;
import com.example.estacionamento.service.ClienteService;




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
	private VeiculoRepository  veiculoRepository;
	
	@Autowired
    private ClienteRepository clienteRepository; // Supondo que você tenha um repositório de usuários
	
	@Autowired
	private ClienteService clienteService;
	
	private Cliente cliente = new Cliente();
	private DonoEstacionamento dono = new DonoEstacionamento();
	private Estacionamento estacionamento= new Estacionamento();

	
	@GetMapping("/vaga")
    public String exibirFormularioLogin(Model model) {
	
		model.addAttribute("esta", ESTrepository.findAll());
        
        return "estacionamento/vaga"; // Retorna a página de login
    }
	
    @PostMapping("/Perfil")
    public String fazerLogin(@RequestParam String senha, @RequestParam String email, Model model) {
        // Verifique se o usuário existe no banco de dados
        Cliente usuario = clienteRepository.findBySenhaAndEmail(senha, email);
        DonoEstacionamento donoEsta = reposito.findBySenhaAndEmail(senha, email);
        if (usuario != null) {
        	System.out.println("usuario: " + usuario);
        	this.cliente.setId(usuario.getId());
            return "redirect:/estacionamento/Perfil/logado";
            
        } else if(donoEsta != null) {
        	System.out.println("Usuário (dono de estacionamento) logado: " + donoEsta);

	        model.addAttribute("donoEstacionamento", donoEsta); 
	        this.dono.setId(dono.getId());
	        return "redirect:/estacionamento/CadastroEstacionamento";
            // Usuário inválido, mostre uma mensagem de erro
        }else {
        	System.out.println("erro CPF ou email inválidos");
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
	public String carregaPaginaEstacionamento_Cadastro(Model model){

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
	 @GetMapping("/veiculo")
	 public String carregaPaginaVeiculo(Model model) {
			model.addAttribute("listaveiculo", veiculoRepository.findAll());
		 
		 return "estacionamento/veiculo";
	 }
	 @GetMapping("/Perfil")
	public String carregaPerfil(Model model) {
		System.out.println("Cliente: " + cliente);
		return "estacionamento/Perfil";
	}
	
	@GetMapping("/Perfil/logado")
	public String carregaPerfilLogado(Model model) {
		Optional<Cliente> clienteSelecionado = clienteRepository.findById(this.cliente.getId());
		System.out.println("ClienteSelecionado: " + clienteSelecionado);
		model.addAttribute("nomeCliente", clienteSelecionado.get().getNome());
		model.addAttribute("emailCliente", clienteSelecionado.get().getEmail());
		return "estacionamento/Perfil";
	}
	
	@Transactional
	@GetMapping("/registroAtendimento/{id}")
	public String carregaRegistro(@PathVariable Long id, Model model) {
		Optional<Estacionamento> estacionamentoSelecionado = ESTrepository.findById(id);
		/*List<Veiculo> veiculosDoCliente = veiculoRepository.findByCliente(cliente);
		model.addAttribute("listaveiculo", veiculosDoCliente);*/
		model.addAttribute("listaveiculo",  veiculoRepository.findAll());
		model.addAttribute("estacionamentoId", estacionamentoSelecionado.get().getId());
		model.addAttribute("estacionamentoNome", estacionamentoSelecionado.get().getNome());
		model.addAttribute("clienteId", this.cliente.getId());
		System.out.println("listaVeiculo: " + model.getAttribute("listaVeiculoCliente"));
		return "estacionamento/registroAtendimento";
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
	
		var donoestacionamento = new DonoEstacionamento(dados_2,estacionamento.getId());
	    reposito.save(donoestacionamento);
	    System.out.println(donoestacionamento);
	    
	    ESTrepository.save(estacionamento);
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
	
	@PostMapping("/veiculo")
	public String cadastraVeiculo(CadastraVeiculo veiculo, Model model){
		//Cliente clienteExistente = clienteRepository.findById(this.cliente.getId()).orElse(null);
		Cliente clienteAtualizado = new Cliente();
		var veiculo1 = new Veiculo(veiculo, cliente.getId());
		List<Veiculo> veiculosCliente = veiculoRepository.findByCliente(cliente);
		
		clienteAtualizado.setVeiculos(veiculosCliente);
		
	    veiculoRepository.save(veiculo1);	
	    clienteService.atualizarCliente(this.cliente.getId(), clienteAtualizado);
	    
	    model.addAttribute("listaVeiculos", veiculoRepository.findAll());
	    return "estacionamento/veiculo";
	}
}
