package com.db1.conta.contaapi.domain.entity;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class HistoricoTest {
	
	@Test
	public void deveRetornarDataObrigatorio() {
		Conta conta = Mockito.mock(Conta.class);
		String mensagem = null;
		try {
			Historico historico = new Historico(null, 1000.0, 4000.0, TipoHistorico.SAIDA);
		}catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Data é obrigatória", mensagem);
	}
	
	@Test
	public void deveRetornarValorObrigatorio() {
		Conta conta = Mockito.mock(Conta.class);
		String mensagem = null;
		try {
			Historico historico = new Historico(LocalDateTime.now(), null, 4000.0, TipoHistorico.SAIDA);
		}catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("O valor é inválido", mensagem);
	}
	
	@Test
	public void deveRetornarValorResultadoObrigatorio() {
		Conta conta = Mockito.mock(Conta.class);
		String mensagem = null;
		try {
			Historico historico = new Historico(LocalDateTime.now(), 1000.0, null, TipoHistorico.SAIDA);
		}catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("O valor final é inválido", mensagem);
	}
	
	@Test
	public void deveRetornarTipoHistoricoObrigatorio() {
		Conta conta = Mockito.mock(Conta.class);
		String mensagem = null;
		try {
			Historico historico = new Historico(LocalDateTime.now(), 1000.0, 4000.0, null);
		}catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("O tipo do histórico é obrigatório", mensagem);
	}
	
//	@Test
//	public void deveRetornarContaObrigatorio() {
//		Conta conta = Mockito.mock(Conta.class);
//		String mensagem = null;
//		try {
//			Historico historico = new Historico(LocalDateTime.now(), 1000.0, 4000.0, TipoHistorico.SAIDA, null);
//		}catch (Exception e) {
//			mensagem = e.getMessage();
//		}
//		Assert.assertEquals("A conta é obrigatória", mensagem);
//	}
	
	@Test
	public void deveCriarUmaInstanciaHistorico() {
		Conta conta = Mockito.mock(Conta.class);
		String mensagem = null;
		Historico historico = null;
		try {
			historico = new Historico(LocalDateTime.now(), 1000.0, 4000.0, TipoHistorico.SAIDA);
		}catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertNull(mensagem);
		Assert.assertEquals(LocalDateTime.now(), historico.getData());
		Assert.assertEquals(1000.0, historico.getValor(), 0000.1);
		Assert.assertEquals(4000.0, historico.getValorResultado(), 0000.1);
		Assert.assertEquals(TipoHistorico.SAIDA, historico.getTipoHistorico());
		//Assert.assertEquals(conta, historico.getConta()); 
	}
}
