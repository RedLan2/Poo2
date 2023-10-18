package com.example.estacionamento.domain.cliente;

import java.util.List;

import com.example.estacionamento.controller.CadastroCliente;
import com.example.estacionamento.controller.alteraCliente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nome")
	private String nome;
	@Column(name="datadenascimento")
	private String dataNascimento;
	@Column(name="cpf")
	private String cpf;
	@Column(name="email")
	private  String email;
	@Column(name="senha")
	private String senha;
	
	/*@OneToMany(mappedBy = "cliente", orphanRemoval = true)
	@JoinColumn(name="veiculo_id", referencedColumnName="veiculo_id")
	private List<Veiculo> veiculo;*/
	//public String carro;
	 @OneToMany(mappedBy = "cliente", orphanRemoval = true)
	    private List<Veiculo> veiculos; 
	 
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	/*public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}*/

	@Override
    public String toString() {
        return "Nome: " + nome +
        		", Data de Nascimento: " + dataNascimento+
               ", Email: " + email +
               ", CPF: " + cpf 
               ;
    }
	
    public Cliente() {
    	
    }
	 public Cliente(CadastroCliente dados) {
	        this.cpf=dados.cpf();
	        this.dataNascimento=dados.dataNascimento();
	        this.email=dados.email();
	        this.nome=dados.nome();
	        this.senha=dados.senha();	        
	    }
	
	 public Cliente(Long id) {
		 this.id = id;
	 }


		public void atualizaDados(alteraCliente dados) {
			// TODO Auto-generated method stub
			this.nome=dados.nome();
			this.cpf=dados.cpf();
			this.email=dados.email();
			
			
		}
}
