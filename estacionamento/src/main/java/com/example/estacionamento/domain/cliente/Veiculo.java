package com.example.estacionamento.domain.cliente;

import com.example.estacionamento.controller.CadastraVeiculo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="veiculo")
public class Veiculo {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="veiculo_id")
    private Long id;
    private String modelo;
    private String cor;
    private String placa;
 
    
  
   
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public Veiculo(CadastraVeiculo dados_Veiculo) {
		this.modelo=dados_Veiculo.modelo();
		this.cor=dados_Veiculo.cor();
		this.placa=dados_Veiculo.placa();

	}

}
