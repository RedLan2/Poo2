package com.example.estacionamento.domain.estacionamento;

import com.example.estacionamento.controller.CadastroEstacionamento;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="estacionamento")
public class Estacionamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	public String nome;
	public String cnpj;
	public String endereco;
	public String horario_funcionamento;
	public String vagas;
	public String valor_vaga;
	

	public String toSring() {
		return "nome: "+ nome +
				",endereço: " + endereco +
				"horario: "+ horario_funcionamento +
				"vagas disponiveis: "+ vagas+
				", valor da vaga " + valor_vaga				
				;
	}
	public Estacionamento() {
		
	}
	
	public Estacionamento(CadastroEstacionamento dados_3) {
		this.nome=dados_3.nome();
		this.endereco=dados_3.endereco();
		this.horario_funcionamento=dados_3.horario_funcionamento();
		this.vagas=dados_3.vagas();
		this.valor_vaga=dados_3.valor_vaga();
		this.cnpj=dados_3.cnpj()
;		
	
	}

	
	
	

}
