package com.example.estacionamento.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.estacionamento.domain.estacionamento.Estacionamento;
import com.example.estacionamento.domain.estacionamento.EstacionamentoRepository;

@Service
public class EstacionamentoService {
	
	private final EstacionamentoRepository ESTrepository = null;
	
	public List<Estacionamento> findByVaga(Long vagas ){
		return null;
	}

}
