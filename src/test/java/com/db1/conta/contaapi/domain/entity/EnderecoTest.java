package com.db1.conta.contaapi.domain.entity;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class EnderecoTest {
	
	@Test
	public void deveRetornarClienteObrigatorio(){
		Cidade cidade = Mockito.mock(Cidade.class); //cidade mockada, para fins de testes e o campo nao tem nenhum comportamento, é utilizado um framework mockito
		String mensagem = null;
		try {
			Endereco endereco = new Endereco(null, "Avenida Center", "800", cidade, TipoEndereco.RESIDENCIAL, null);
		}catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Cliente é obrigatório", mensagem);
	}
	
	@Test
	public void deveRetornarLogradouroObrigatorio(){
		Cliente cliente = Mockito.mock(Cliente.class);
		Cidade cidade = Mockito.mock(Cidade.class);
		String mensagem = null;
		try {
			Endereco endereco = new Endereco(cliente, null, "800", cidade, TipoEndereco.RESIDENCIAL, null);
		}catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Logradouro é obrigatório", mensagem);
	}
	
	@Test
	public void deveRetornarNumeroObrigatorio(){
		Cliente cliente = Mockito.mock(Cliente.class);
		Cidade cidade = Mockito.mock(Cidade.class);
		String mensagem = null;
		try {
			Endereco endereco = new Endereco(cliente, "Avenida Center", null, cidade, TipoEndereco.RESIDENCIAL, null);
		}catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Numero do endereco é obrigatório", mensagem);
	}
	
	@Test
	public void deveRetornarCidadeObrigatorio(){
		Cliente cliente = Mockito.mock(Cliente.class);
		Cidade cidade = Mockito.mock(Cidade.class);
		String mensagem = null;
		try {
			Endereco endereco = new Endereco(cliente, "Avenida Center", "800", null, TipoEndereco.RESIDENCIAL, null);
		}catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Cidade é obrigatório", mensagem);
	}
	
	@Test
	public void deveRetornarTipoEnderecoObrigatorio(){
		Cliente cliente = Mockito.mock(Cliente.class);
		Cidade cidade = Mockito.mock(Cidade.class);
		String mensagem = null;
		try {
		Endereco endereco = new Endereco(cliente, "Avenida Center", "800", cidade, null, null);
		}catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("O tipo de endereço é obrigatório", mensagem);
	}
	
	@Test
	public void deveCriarUmaInstanciaEndereco() {
		Cliente cliente = Mockito.mock(Cliente.class);
		Cidade cidade = Mockito.mock(Cidade.class);
		String mensagem = null;
		Endereco endereco = null;
		try {
			endereco = new Endereco(cliente, "Avenida Center", "800", cidade, TipoEndereco.RESIDENCIAL, null);
		}catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertNull(mensagem);
		Assert.assertEquals(cliente, endereco.getCliente());
		Assert.assertEquals("Avenida Center", endereco.getLogradouro());
		Assert.assertEquals("800", endereco.getNumero());
		Assert.assertEquals(cidade, endereco.getCidade());
		Assert.assertEquals(TipoEndereco.RESIDENCIAL, endereco.getTipoEndereco());
		Assert.assertEquals(null, endereco.getComplemento());
	}
}
