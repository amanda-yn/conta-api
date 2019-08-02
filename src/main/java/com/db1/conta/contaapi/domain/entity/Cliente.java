package com.db1.conta.contaapi.domain.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.util.Assert;

@Entity
@Table(name = "cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", length = 80, nullable = false, unique = true)
	private String nome;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente", fetch = FetchType.LAZY, orphanRemoval = true, targetEntity = Endereco.class) //Cascade : salvar os enderecos junto ao cliente
	private List<Endereco> enderecos = new ArrayList<Endereco>();
	
	//@OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente", fetch = FetchType.LAZY, orphanRemoval = true, targetEntity = Conta.class) 
	//private List<Conta> contas = new ArrayList<Conta>();
	
	@Column(name = "cpf", length = 11, nullable = false, unique = true)
	private String cpf;
	
	protected Cliente() {}
	
	public Cliente(String nome, String cpf) {
		Assert.hasText(nome, "Nome do cliente é obrigatório");
		Assert.hasText(cpf, "CPF do cliente é obrigatório");
		Assert.isTrue(cpf.length() == 11, "CPF inválido");
		
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public void addEndereco(String logradouro, String numero, String cep,  Cidade cidade, TipoEndereco tipoEndereco, String complemento) {
		Endereco endereco = new Endereco(this, logradouro, numero, cep, cidade, tipoEndereco, complemento);
		this.enderecos.add(endereco);
		
	}
	
	public void addEnderecoCobranca(String logradouro, String numero, String cep,  Cidade cidade, TipoEndereco tipoEndereco, String complemento) {
		this.addEndereco(logradouro, numero, cep, cidade, TipoEndereco.COBRANCA, complemento);
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public String getCpf() {
		return cpf;
	}
}
