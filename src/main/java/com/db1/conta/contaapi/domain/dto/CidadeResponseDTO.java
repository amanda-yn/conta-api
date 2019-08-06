package com.db1.conta.contaapi.domain.dto;

import java.io.Serializable;

import com.db1.conta.contaapi.domain.entity.Estado;

public class CidadeResponseDTO implements Serializable{ //Saída - Transferir no banco de dados - Resultado do processamento	

	private static final long serialVersionUID = 3090571035302249904L;

	private Long id;
	
	private String nome;
	
	private Estado estado;
	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}
