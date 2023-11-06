package com.example.estacionamento.domain.cliente;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class VeiculoRepositoryImpl  implements VeiculoRepositoryCustom{

	 @PersistenceContext
	 private EntityManager entityManager;
	
	@Override
	@Transactional
	public List<Veiculo> findByCliente(Long cliente_id) {
		String jpql = "SELECT v FROM Veiculo v  WHERE v.cliente.id = :cliente_id";
        return entityManager.createQuery(jpql, Veiculo.class)
                .setParameter("cliente_id", cliente_id )
                .getResultList();
	}
	
	
	

}
