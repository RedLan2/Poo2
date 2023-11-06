package com.example.estacionamento.domain.reserva;



import com.example.estacionamento.controller.ReservaSalvar;
import com.example.estacionamento.domain.cliente.Cliente;
import com.example.estacionamento.domain.cliente.Veiculo;
import com.example.estacionamento.domain.donoestacionamento.DonoEstacionamento;
import com.example.estacionamento.domain.estacionamento.Estacionamento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="reserva")
public class Reserva {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="reserva_id")
	private Long reserva_id;
	
	@ManyToOne
	@JoinColumn(name="fk_veiculo",referencedColumnName="veiculo_id")
	private Veiculo fk_veiculo;
	@ManyToOne
	@JoinColumn(name="fk_reserva",referencedColumnName="id")
	private Estacionamento fk_estacionamento;
	@ManyToOne
	@JoinColumn(name="fk_cliente", referencedColumnName="id")
	private  Cliente fk_cliente;
	
	
	public Long getReserva_id() {
		return reserva_id;
	}
	public void setReserva_id(Long reserva_id) {
		this.reserva_id = reserva_id;
	}





	
	public Veiculo getFk_veiculo() {
		return fk_veiculo;
	}
	public void setFk_veiculo(Veiculo fk_veiculo) {
		this.fk_veiculo = fk_veiculo;
	}
	public Cliente getFk_cliente() {
		return fk_cliente;
	}
	public void setFk_cliente(Cliente fk_cliente) {
		this.fk_cliente = fk_cliente;
	}
	public Estacionamento getFk_estacionamento() {
		return fk_estacionamento;
	}
	public void setFk_estacionamento(Estacionamento fk_estacionamento) {
		this.fk_estacionamento = fk_estacionamento;
	}
	//public Reserva(Veiculo veiculo, Long cliente_id) {
	//	this.setFk_cliente(new Cliente(cliente_id));
	//	this.setFk_veiculo(new Veiculo(veiculo.getId()));
	//}
	
	public Reserva(Reserva reserva, Long cliente_id, Long estacionamento_id) {
		this.setFk_cliente(new Cliente(cliente_id));
		this.setFk_estacionamento(new Estacionamento(estacionamento_id));
		this.setFk_veiculo(new Veiculo(reserva.getFk_veiculo().getId()));
	}
	
	public Reserva() {
	
	}
	
	
}
