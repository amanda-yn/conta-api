package com.db1.conta.contaapi.domain.entity;

import org.junit.Assert;
import org.junit.Test;

public class CidadeTest {

	private Cidade cidade = null;

	@Test
	public void deveRetornarNomeObrigatorio() {
		String mensagem = null;
		try {
			cidade = new Cidade(null, Estado.AC);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Nome é obrigatório", mensagem);
	}

	@Test
	public void deveRetornarEstadoObrigatorio() {
		String mensagem = null;
		try {
			cidade = new Cidade("Maringá", null);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Estado é obrigatório", mensagem);
	}

	@Test
	public void deveCriarUmaInstanciaCidade() {
		String mensagem = null;

		try {
			cidade = new Cidade("Maringá", Estado.PR);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertNull(mensagem);
		Assert.assertEquals("Maringá", cidade.getNome());
		Assert.assertEquals(Estado.PR, cidade.getEstado());
	}
}
