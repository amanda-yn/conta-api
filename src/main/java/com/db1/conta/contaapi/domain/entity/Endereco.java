package com.db1.conta.contaapi.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.util.Assert;

@Entity
@Table(name = "endereco",
		uniqueConstraints = @UniqueConstraint(columnNames = { "logradouro", "cidade_id"}))
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne 
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;
	
	@Column(name = "logradouro", length = 100, nullable = false)
	private String logradouro;
	
	@Column(name = "numero", length = 20, nullable = false)
	private String numero;
	
	@Column(name = "cep", length = 9, nullable = false)
	private String cep;
	
	@ManyToOne 
	@JoinColumn(name = "cidade_id", nullable = false)
	private Cidade cidade;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipoEndereco", length = 11, nullable = false)
	private TipoEndereco tipoEndereco;
	
	@Column(name = "complemento", length = 100)
	private String complemento; 
	
	protected Endereco() {}
	
	public Endereco(Cliente cliente, String logradouro, String numero, String cep,  Cidade cidade, TipoEndereco tipoEndereco, String complemento) {
		Assert.hasText(logradouro, "Logradouro é obrigatório");
		Assert.hasText(numero, "Número do endereco é obrigatório");
		Assert.hasText(cep, "CEP é obrigatório");
		Assert.isTrue(cep.length() == 9, "CEP inválido"); 
		Assert.notNull(cliente, "Cliente é obrigatório");
		Assert.notNull(cidade, "Cidade é obrigatório");
		Assert.notNull(tipoEndereco, "O tipo de endereço é obrigatório");
		
		this.cliente = cliente;
		this.logradouro = logradouro;
		this.numero = numero;
		this.cep = cep;
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

	public String getCep() {
		return cep;
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
