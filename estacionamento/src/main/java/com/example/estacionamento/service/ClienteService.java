package com.example.estacionamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.estacionamento.domain.cliente.Cliente;
import com.example.estacionamento.domain.cliente.ClienteRepository;
import com.example.estacionamento.domain.cliente.Veiculo;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente atualizarCliente(Long id, Cliente clienteAtualizado) {
        Cliente clienteExistente = clienteRepository.findById(id).orElse(null);
        
        if (clienteExistente != null) {
            clienteExistente.setVeiculos(clienteAtualizado.getVeiculos());
            
            return clienteRepository.save(clienteExistente);
        } else {
            return null;
        }
    }
    
    public void atualizaVeiculoCliente(List<Veiculo> veiculos, Long cliente_id) {
        clienteRepository.atualizarVeiculosDoCliente(veiculos, cliente_id);
    }
}