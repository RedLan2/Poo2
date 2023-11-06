package com.example.estacionamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.estacionamento.domain.cliente.Cliente;
import com.example.estacionamento.domain.cliente.Veiculo;
import com.example.estacionamento.domain.cliente.VeiculoRepository;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    @Autowired
    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public List<Veiculo> findByCliente(Long cliente_id) {
        return veiculoRepository.findByCliente(cliente_id);
    }
}