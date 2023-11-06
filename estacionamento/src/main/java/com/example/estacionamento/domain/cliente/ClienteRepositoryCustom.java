package com.example.estacionamento.domain.cliente;

import java.util.List;

public interface ClienteRepositoryCustom {
	Cliente atualizaVeiculoCliente(List<Veiculo> veiculos, Long cliente_id);

}
