package com.db1.conta.contaapi.domain.entity;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ContaTest {
	
	@Test
	public void deveRetornarNumeroDaContaObrigatorio() {
		Agencia agencia = Mockito.mock(Agencia.class);
		Cliente cliente = Mockito.mock(Cliente.class);
		String mensagem = null;
		try {
			Conta contas = new Conta(agencia, null, TipoConta.CORRENTE, cliente, 5000.0);
		}catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("O número da conta é obrigatória", mensagem);
	}
	
	@Test
	public void deveRetornarSaldoObrigatorio() {
		Agencia agencia = Mockito.mock(Agencia.class);
		Cliente cliente = Mockito.mock(Cliente.class);
		String mensagem = null;
		try {
			Conta contas = new Conta(agencia, "0000009999", TipoConta.CORRENTE, cliente, null);
		}catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Saldo inválido", mensagem);
	}
	
	@Test
	public void deveRetornarAgenciaObrigatorio() {
		Cliente cliente = Mockito.mock(Cliente.class);
		String mensagem = null;
		try {
			Conta contas = new Conta(null, "0000009999", TipoConta.CORRENTE, cliente, 5000.0);
		}catch (Exception e) {
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
			Conta contas = new Conta(agencia, "0000009999", null, cliente, 5000.0);
		}catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("O tipo da conta é obrigatório", mensagem);
	}
	
	@Test
	public void deveRetornarClienteObrigatorio() {
		Agencia agencia = Mockito.mock(Agencia.class);
		String mensagem = null;
		try {
			Conta contas = new Conta(agencia, "0000009999", TipoConta.CORRENTE, null, 5000.0);
		}catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("O cliente é obrigatório", mensagem);
	}
	
	@Test
	public void deveCriarUmaInstanciaConta() {
		Agencia agencia = Mockito.mock(Agencia.class);
		Cliente cliente = Mockito.mock(Cliente.class);
		Conta contas = null;
		String mensagem = null;
		try {
			contas = new Conta(agencia, "0000009999", TipoConta.CORRENTE, cliente, 5000.0);
		}catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertNull(mensagem);
		Assert.assertEquals(agencia, contas.getAgencia());
		Assert.assertEquals("0000009999", contas.getNumero());
		Assert.assertEquals(TipoConta.CORRENTE, contas.getTipoConta());
		Assert.assertEquals(cliente, contas.getCliente());
		Assert.assertEquals(5000.0, contas.getSaldo(), 0000.1);
	}
}
