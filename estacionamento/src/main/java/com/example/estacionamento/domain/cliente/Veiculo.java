package com.example.estacionamento.domain.cliente;

import java.util.Objects;

import com.example.estacionamento.controller.CadastraVeiculo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
   

	@ManyToOne
	@JoinColumn(name="cliente_id", referencedColumnName="id")
	private Cliente cliente;
    
    
   
    
    
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
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Veiculo() {}
	
	public Veiculo(Long id) {
		this.id = id;
	}
	
	public Veiculo(CadastraVeiculo dados_Veiculo) {
		this.modelo=dados_Veiculo.modelo();
		this.cor=dados_Veiculo.cor();
		this.placa=dados_Veiculo.placa();

	}
	
	public Veiculo(CadastraVeiculo dados_Veiculo, Long clienteId) {
		this.modelo=dados_Veiculo.modelo();
		this.cor=dados_Veiculo.cor();
		this.placa=dados_Veiculo.placa();
		this.setCliente(new Cliente(clienteId));
	}
	@Override
	public int hashCode() {
		return Objects.hash(cliente, cor, id, modelo, placa);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(cor, other.cor) && Objects.equals(id, other.id)
				&& Objects.equals(modelo, other.modelo) && Objects.equals(placa, other.placa);
	}
}
