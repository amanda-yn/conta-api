package com.db1.conta.contaapi.domain.dto;

import java.io.Serializable;

import com.db1.conta.contaapi.domain.entity.Estado;

//Maikon usa na entrada o nome Persist
public class CidadePersistDTO implements Serializable{ //Entrada - Front-end

	private static final long serialVersionUID = 7041215295972851764L;
	
	private String nome;
	private Estado estado;
	
	public String getNome() {
		return nome;
	}
	
	public Estado getEstado() {
		return estado;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
}
