package com.example.estacionamento.domain.donoestacionamento;

import com.example.estacionamento.controller.CadastroDonoEstacionamento;
import com.example.estacionamento.domain.estacionamento.Estacionamento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="donoestacionamento")
public class DonoEstacionamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	
	private String datadenascimento;
	
	private String cpf;

	private  String email;

	private String senha;

	private String numero;
	
	/*@ManyToOne
	@JoinColumn(name="estacionamento_id", referencedColumnName="id")
	private Estacionamento estacionamento;*/
	
	@OneToMany(mappedBy="dono", orphanRemoval=true)
	
	



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

	public String getDatadenascimento() {
		return datadenascimento;
	}

	public void setDatadenascimento(String datadenascimento) {
		this.datadenascimento = datadenascimento;
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	
	@Override
	public String toString() {
		return "Nome: " + nome +
        		", Data de Nascimento: " + datadenascimento+
                ", Email: " + email +
                ", CPF: " + cpf +
                ",numero"+ numero+
                ",senha"+ senha
                ;
	}
	
	public DonoEstacionamento() {
		
	}
	
	public DonoEstacionamento(Long id) {
		this.id=id;
	}
	public DonoEstacionamento( CadastroDonoEstacionamento dados_2) {
		
		this.cpf=dados_2.cpf();
		this.datadenascimento=dados_2.datadenascimento();
		this.email=dados_2.email();
	    this.nome=dados_2.nome();
	    this.numero=dados_2.numero();
	    this.senha=dados_2.senha();   
	}
public DonoEstacionamento( CadastroDonoEstacionamento dados_2, Long estacionamentoID) {
	
	this.cpf=dados_2.cpf();
	this.datadenascimento=dados_2.datadenascimento();
	this.email=dados_2.email();
    this.nome=dados_2.nome();
    this.numero=dados_2.numero();
    this.senha=dados_2.senha();   
    //this.setEstacionamento(new Estacionamento(estacionamentoID));
  }



}
