package com.example.estacionamento.domain.cliente;

import java.util.List;

public interface VeiculoRepositoryCustom {
	List<Veiculo> findByCliente(Long cliente_id);
}
