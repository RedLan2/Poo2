package com.example.estacionamento.domain.cliente;

import com.example.estacionamento.controller.CadastroCliente;

public class Cliente {
	
	public int id;
	public String nome;
	public String dataNascimento;
	public String cpf;
	public String email;

    @Override
    public String toString() {
        return "Nome: " + nome +
               ", Email: " + email +
               ", CPF: " + cpf +
               ", Data de Nascimento: " + dataNascimento;
    }
	
	 public Cliente(CadastroCliente dados) {
	        this.cpf=dados.cpf();
	        this.dataNascimento=dados.datanascimento();
	        this.email=dados.email();
	        this.nome=dados.nome();
	        
	    }

	public void add(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

}
