package com.example.estacionamento.domain.estacionamento;

import com.example.estacionamento.controller.CadastroEstacionamento;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="estacionamento")
public class Estacionamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String cnpj;
	private String endereco;
	private String horario_funcionamento;
	private String vagas;
	private String valor_vaga;
	
	@ManyToOne
	@JoinColumn(name="dono_estacionamento_id", referencedColumnName="id")
	
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
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getHorario_funcionamento() {
		return horario_funcionamento;
	}
	public void setHorario_funcionamento(String horario_funcionamento) {
		this.horario_funcionamento = horario_funcionamento;
	}
	public String getVagas() {
		return vagas;
	}
	public void setVagas(String vagas) {
		this.vagas = vagas;
	}
	public String getValor_vaga() {
		return valor_vaga;
	}
	public void setValor_vaga(String valor_vaga) {
		this.valor_vaga = valor_vaga;
	}
	
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