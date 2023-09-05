package com.example.estacionamento.domain.cliente;

import com.example.estacionamento.controller.CadastroDonoEstacionamento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="DonoEstacionamento")
public class DonoEstacionamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	@Column(name = "nome")
	public String nome;
	@Column(name="datadenascimento")
	public String dataNascimento;
	@Column(name="cpf")
	public String cpf;
	@Column(name="email")
	public  String email;
	@Column(name="senha")
	public String senha;
	@Column(name="numero")
	public int numero;
	
	@Override
	public String toString() {
		return "Nome: " + nome +
        		", Data de Nascimento: " + dataNascimento+
                ", Email: " + email +
                ", CPF: " + cpf +
                ",numero"+ numero+
                "senha"+ senha
                ;
	}
	
	public DonoEstacionamento() {
		
	}
public DonoEstacionamento( CadastroDonoEstacionamento dados_2) {
	
	this.cpf=dados_2.cpf();
	this.dataNascimento=dados_2.dataNascimento();
	this.email=dados_2.email();
    this.nome=dados_2.nome();
    this.numero=dados_2.numero();
    this.senha=dados_2.senha();   
  }
}
