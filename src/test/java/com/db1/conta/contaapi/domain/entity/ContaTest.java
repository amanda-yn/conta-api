package com.db1.conta.contaapi.domain.entity;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ContaTest {

	private Conta conta = null;

	@Test
	public void deveRetornarNumeroDaContaObrigatorio() {
		Agencia agencia = Mockito.mock(Agencia.class);
		Cliente cliente = Mockito.mock(Cliente.class);
		String mensagem = null;
		try {
			conta = new Conta(agencia, null, TipoConta.CORRENTE, cliente);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("O número da conta é obrigatória", mensagem);
	}

	@Test
	public void deveRetornarAgenciaObrigatorio() {
		Cliente cliente = Mockito.mock(Cliente.class);
		String mensagem = null;
		try {
			conta = new Conta(null, "0000009999", TipoConta.CORRENTE, cliente);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Agência é obrigatório", mensagem);
	}

	@Test
	public void deveRetornarTipoContaObrigatorio() {
		Agencia agencia = Mockito.mock(Agencia.class);
		Cliente cliente = Mockito.mock(Cliente.class);
		String mensagem = null;
		try {
			conta = new Conta(agencia, "0000009999", null, cliente);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("O tipo da conta é obrigatório", mensagem);
	}

	@Test
	public void deveRetornarClienteObrigatorio() {
		Agencia agencia = Mockito.mock(Agencia.class);
		String mensagem = null;
		try {
			conta = new Conta(agencia, "0000009999", TipoConta.CORRENTE, null);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("O cliente é obrigatório", mensagem);
	}

	@Test
	public void deveCriarUmaInstanciaConta() {
		Agencia agencia = Mockito.mock(Agencia.class);
		Cliente cliente = Mockito.mock(Cliente.class);
		String mensagem = null;
		try {
			conta = new Conta(agencia, "0000009999", TipoConta.CORRENTE, cliente);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertNull(mensagem);
		Assert.assertEquals(agencia, conta.getAgencia());
		Assert.assertEquals("0000009999", conta.getNumero());
		Assert.assertEquals(TipoConta.CORRENTE, conta.getTipoConta());
		Assert.assertEquals(cliente, conta.getCliente());
		Assert.assertEquals(0.0, conta.getSaldo(), 0.0);
	}
}
