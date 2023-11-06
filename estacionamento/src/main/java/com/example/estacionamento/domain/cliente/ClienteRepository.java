package com.example.estacionamento.domain.cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	@Modifying
    @Query("UPDATE Cliente c set c.veiculos = :listaVeiculos WHERE c.id = :clienteId")
    void atualizarVeiculosDoCliente(@Param("listaVeiculos") List<Veiculo> veiculos, @Param("clienteId") Long clienteId);
	
	Cliente findBySenhaAndEmail(String senha, String email);
}
