package com.db1.conta.contaapi.domain.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.util.Assert;

@Entity
@Table(name = "conta")
public class Conta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "agencia_id", nullable = false)
	private Agencia agencia;
	
	@Column(name = "numero", length = 10, nullable = false, unique = true)
	private String numero;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipoConta", length = 8, nullable = false)
	private TipoConta tipoConta;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;
	
	@Column(name = "saldo", precision = 14, scale = 2, nullable = false)
	private Double saldo; 
	
	@ElementCollection
	@CollectionTable(name="historico_conta", joinColumns = @JoinColumn(name = "conta_id"))
	private List<Historico> conta = new ArrayList<Historico>();
	
	protected Conta() {}
	
	public Conta (Agencia agencia, String numero, TipoConta tipoConta, Cliente cliente, Double saldo){
		Assert.hasText(numero, "O número da conta é obrigatória");
		Assert.notNull(saldo, "Saldo inválido");
		Assert.notNull(agencia, "Agência é obrigatório");
		Assert.notNull(tipoConta, "O tipo da conta é obrigatório");
		Assert.notNull(cliente, "O cliente é obrigatório");
		
		this.agencia = agencia;
		this.numero = numero;
		this.tipoConta = tipoConta;
		this.cliente = cliente;
		this.saldo = saldo;
	}

	public Long getId() {
		return id;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public String getNumero() {
		return numero;
	}

	public TipoConta getTipoConta() {
		return tipoConta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Double getSaldo() {
		return saldo;
	}
}
