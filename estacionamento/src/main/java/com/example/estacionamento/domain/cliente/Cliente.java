package com.example.estacionamento.domain.cliente;

import com.example.estacionamento.controller.CadastroCliente;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	
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
	//public String carro;

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
	        
	    }

}
