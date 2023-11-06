package com.example.estacionamento.domain.cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VeiculoRepository  extends JpaRepository<Veiculo,Long>, VeiculoRepositoryCustom {
	//List<Veiculo> findByCliente(@Param("clienteId") Long cliente_id);
}
