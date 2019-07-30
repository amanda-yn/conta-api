package com.db1.conta.contaapi.domain.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.Assert;

public class Cliente {
	private Long id;
	private String nome;
	private List<Endereco> enderecos = new ArrayList<>();
	private List<Contas> contas = new ArrayList<>();
	private String cpf;
	
	public Cliente(String nome, String cpf) {
		Assert.hasText(nome, "Nome é obrigatório");
		Assert.hasText(cpf, "CPF é obrigatório");
		Assert.notNull(enderecos, "Endereco é obrigatório");
		Assert.isTrue(cpf.length() == 11, "CPF é inválido");
		this.nome = nome;
		this.cpf = cpf;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}
}
