package com.db1.conta.contaapi.domain.entity;

import org.springframework.util.Assert;

public class Endereco {
	private Long id;
	private Cliente cliente;
	private String logradouro;
	private String numero;
	private Cidade cidade;
	private TipoEndereco tipoEndereco;
	private String complemento; //falta cep
	
	public Endereco(Cliente cliente, String logradouro, String numero,  Cidade cidade, TipoEndereco tipoEndereco, String complemento) {
		Assert.hasText(logradouro, "Logradouro é obrigatório");
		Assert.hasText(numero, "Número do endereco é obrigatório");
		Assert.notNull(cliente, "Cliente é obrigatório");
		Assert.notNull(cidade, "Cidade é obrigatório");
		Assert.notNull(tipoEndereco, "O tipo de endereço é obrigatório");
		
		this.cliente = cliente;
		this.logradouro = logradouro;
		this.numero = numero;
		this.cidade = cidade;
		this.tipoEndereco = tipoEndereco;
		this.complemento = complemento;
	}

	public Long getId() {
		return id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public TipoEndereco getTipoEndereco() {
		return tipoEndereco;
	}

	public String getComplemento() {
		return complemento;
	}
}
