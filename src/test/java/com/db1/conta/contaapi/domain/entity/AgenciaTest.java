package com.db1.conta.contaapi.domain.entity;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class AgenciaTest {

	private Agencia agencia = null;
	
	@Test
	public void deveRetornarNumeroDaAgenciaObrigatorio() {
		Cidade cidade = Mockito.mock(Cidade.class);
		String mensagem = null;
		try {
			agencia = new Agencia(null, "1", cidade);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("O número da agência é obrigatório", mensagem);
	}

	@Test
	public void deveRetornarDigitoDaAgenciaObrigatorio() {
		Cidade cidade = Mockito.mock(Cidade.class);
		String mensagem = null;
		try {
			agencia = new Agencia("001", null, cidade);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("O dígito da agência é obrigatório", mensagem);
	}

	@Test
	public void deveRetornarCidadeObrigatorio() {
		String mensagem = null;
		try {
			agencia = new Agencia("001", "1", null);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Cidade é obrigatório", mensagem);
	}

	@Test
	public void deveCriarInstanciaAgencia() {
		Cidade cidade = Mockito.mock(Cidade.class);
		String mensagem = null;
		try {
			agencia = new Agencia("001", "1", cidade);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertNull(mensagem);
		Assert.assertEquals("001", agencia.getNumero());
		Assert.assertEquals("1", agencia.getDigito());
		Assert.assertEquals(cidade, agencia.getCidade());
	}
}
