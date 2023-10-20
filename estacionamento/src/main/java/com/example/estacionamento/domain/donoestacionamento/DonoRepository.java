package com.example.estacionamento.domain.donoestacionamento;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DonoRepository extends JpaRepository<DonoEstacionamento, Long>{

	DonoEstacionamento findBySenhaAndEmail(String senha, String email);

}
