package com.example.estacionamento.domain.cliente;

import com.example.estacionamento.controller.CadastroDonoEstacionamento;

import jakarta.persistence.Column;

public class DonoEstacionamento {
	
	public Long id;
	@Column(name = "nome")
	public String nome;
	@Column(name="datadenascimento")
	public String dataNascimento;
	@Column(name="cpf")
	public String cpf;
	@Column(name="email")
	public  String email;
	public String senha;
	public int numero;
	
	
	public String toString_2() {
		return "Nome: " + nome +
        		", Data de Nascimento: " + dataNascimento+
                ", Email: " + email +
                ", CPF: " + cpf 
                ;
	}
	
public DonoEstacionamento(CadastroDonoEstacionamento dados_2) {
	
	this.cpf=dados_2.cpf();
	this.dataNascimento=dados_2.dataNascimento();
	this.email=dados_2.email();
    this.nome=dados_2.nome();
    this.numero=dados_2.numero();
    this.senha=dados_2.senha();   
  }
}
