package com.example.estacionamento.controller;

public record CadastroEstacionamento(String nome,
		 String cnpj,
		 String endereco,
		 String horario_funcionamento,
			 String vagas,
			 String valor_vaga) {

}
