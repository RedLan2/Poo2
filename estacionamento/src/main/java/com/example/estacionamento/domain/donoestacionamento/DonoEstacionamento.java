package com.example.estacionamento.domain.donoestacionamento;

import com.example.estacionamento.controller.CadastroDonoEstacionamento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="donoestacionamento")
public class DonoEstacionamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	public String nome;
	
	public String datadenascimento;
	
	public String cpf;

	public  String email;

	public String senha;

	public String numero;
	
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
public DonoEstacionamento( CadastroDonoEstacionamento dados_2) {
	
	this.cpf=dados_2.cpf();
	this.datadenascimento=dados_2.datadenascimento();
	this.email=dados_2.email();
    this.nome=dados_2.nome();
    this.numero=dados_2.numero();
    this.senha=dados_2.senha();   
  }
}
