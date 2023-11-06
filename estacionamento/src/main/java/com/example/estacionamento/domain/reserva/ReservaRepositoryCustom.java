package com.example.estacionamento.domain.reserva;

import java.util.List;

import com.example.estacionamento.domain.estacionamento.Estacionamento;

public interface ReservaRepositoryCustom {
	List<Estacionamento> findByVaga(Long vagas);

}
