package com.example.estacionamento.domain.cliente;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class ClienteRepositorylmpl  implements ClienteRepositoryCustom{

	 @PersistenceContext
	 private EntityManager entityManager;
	
	@Modifying
	@Override
	public Cliente atualizaVeiculoCliente(List<Veiculo> veiculos, Long cliente_id) {
		String jpql = "UPDATE Cliente c set c.veiculos = :listaVeiculos WHERE c.id = :clienteId";
		return (Cliente) entityManager.createQuery(jpql, Cliente.class)
				.setParameter("listaVeiculos", veiculos )
                .setParameter("clienteId", cliente_id )
                .getResultList();
	}

	
	
}
