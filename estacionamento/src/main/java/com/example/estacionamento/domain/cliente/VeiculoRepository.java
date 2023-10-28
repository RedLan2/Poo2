package com.example.estacionamento.domain.cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository  extends JpaRepository<Veiculo,Long>{
	List<Veiculo> findByCliente(Cliente cliente);
}
