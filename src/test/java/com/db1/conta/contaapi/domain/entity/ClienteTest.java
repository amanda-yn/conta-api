package com.db1.conta.contaapi.domain.entity;

import org.junit.Assert;
import org.junit.Test;

public class ClienteTest {

	private Cliente cliente = null;

	@Test
	public void deveRetornarNomeObrigatorio() {
		String mensagem = null;
		try {
			cliente = new Cliente(null, "00000000000");
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Nome do cliente é obrigatório", mensagem);
	}

	@Test
	public void deveRetornarCpfObrigatorio() {
		String mensagem = null;
		try {
			cliente = new Cliente("José", null);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("CPF do cliente é obrigatório", mensagem);
	}

	@Test
	public void deveRetornarCpfInvalido() {
		String mensagem = null;
		try {
			cliente = new Cliente("José", "000000000000");
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("CPF inválido", mensagem);
	}

	@Test
	public void deveRetornarCriarUmaInstanciaCliente() {
		String mensagem = null;
		try {
			cliente = new Cliente("José", "00000000000");
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertNull(mensagem);
		Assert.assertEquals("José", cliente.getNome());
		Assert.assertEquals("00000000000", cliente.getCpf());
	}
}
