package com.db1.conta.contaapi.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.springframework.util.Assert;

@Embeddable
@Table(name = "historico")
public class Historico {
	
	//private Long id;
	
	@Column(name = "data", nullable = false)
	private LocalDateTime data;
	
	@Column(name = "valor", precision = 14, scale = 2, nullable = false)
	private Double valor;
	
	@Column(name = "valorResultado", precision = 14, scale = 2, nullable = false)
	private Double valorResultado;
	
	@Enumerated(EnumType.STRING)
    @Column(name = "tipoHistorico", length = 11, nullable = false)
	private TipoHistorico tipoHistorico;
	//private Conta conta;
	
	protected Historico() {}
	
	public Historico(LocalDateTime data, Double valor, Double valorResultado, TipoHistorico tipoHistorico) {
		Assert.notNull(valor, "O valor é inválido");
		Assert.notNull(valorResultado, "O valor final é inválido");
		Assert.notNull(data, "Data é obrigatória");
		Assert.notNull(tipoHistorico, "O tipo do histórico é obrigatório");
		//Assert.notNull(conta, "A conta é obrigatória");
		
		this.data = LocalDateTime.now();
		this.valor = valor;
		this.valorResultado = valorResultado;
		this.tipoHistorico = tipoHistorico;
		//this.conta = conta;
	}

	//public Long getId() {
	//	return id;
	//}

	public LocalDateTime getData() {
		return data;
	}

	public Double getValor() {
		return valor;
	}

	public Double getValorResultado() {
		return valorResultado;
	}

	public TipoHistorico getTipoHistorico() {
		return tipoHistorico;
	}

//	public Conta getConta() {
//		return conta;
//	}
}
