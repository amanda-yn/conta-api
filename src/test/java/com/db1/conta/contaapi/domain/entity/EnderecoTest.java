package com.db1.conta.contaapi.domain.entity;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class EnderecoTest {

	private Endereco endereco = null;

	@Test
	public void deveRetornarClienteObrigatorio() {
		// Para fins de testes e quando o campo nao tem nenhum comportamento
		// é utilizado um framework chamado mockito
		Cidade cidade = Mockito.mock(Cidade.class);
		String mensagem = null;
		try {
			endereco = new Endereco(null, "Avenida Center", "800", "00000-000", cidade, TipoEndereco.RESIDENCIAL, null);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Cliente é obrigatório", mensagem);
	}

	@Test
	public void deveRetornarLogradouroObrigatorio() {
		Cliente cliente = Mockito.mock(Cliente.class);
		Cidade cidade = Mockito.mock(Cidade.class);
		String mensagem = null;
		try {
			endereco = new Endereco(cliente, null, "800", "00000-000", cidade, TipoEndereco.RESIDENCIAL, null);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Logradouro é obrigatório", mensagem);
	}

	@Test
	public void deveRetornarNumeroObrigatorio() {
		Cliente cliente = Mockito.mock(Cliente.class);
		Cidade cidade = Mockito.mock(Cidade.class);
		String mensagem = null;
		try {
			endereco = new Endereco(cliente, "Avenida Center", null, "00000-000", cidade, TipoEndereco.RESIDENCIAL,
					null);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Número do endereco é obrigatório", mensagem);
	}

	@Test
	public void deveRetornarCepObrigatorio() {
		Cliente cliente = Mockito.mock(Cliente.class);
		Cidade cidade = Mockito.mock(Cidade.class);
		String mensagem = null;
		try {
			endereco = new Endereco(cliente, "Avenida Center", "800", null, cidade, TipoEndereco.RESIDENCIAL, null);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("CEP é obrigatório", mensagem);
	}

	@Test
	public void deveRetornarCepInvalido() {
		Cliente cliente = Mockito.mock(Cliente.class);
		Cidade cidade = Mockito.mock(Cidade.class);
		String mensagem = null;
		try {
			endereco = new Endereco(cliente, "Avenida Center", "800", "000001-000", cidade, TipoEndereco.RESIDENCIAL,
					null);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("CEP inválido", mensagem);
	}

	@Test
	public void deveRetornarCidadeObrigatorio() {
		Cliente cliente = Mockito.mock(Cliente.class);
		String mensagem = null;
		try {
			endereco = new Endereco(cliente, "Avenida Center", "800", "00000-000", null, TipoEndereco.RESIDENCIAL,
					null);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("Cidade é obrigatório", mensagem);
	}

	@Test
	public void deveRetornarTipoEnderecoObrigatorio() {
		Cliente cliente = Mockito.mock(Cliente.class);
		Cidade cidade = Mockito.mock(Cidade.class);
		String mensagem = null;
		try {
			endereco = new Endereco(cliente, "Avenida Center", "800", "00000-000", cidade, null, null);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertEquals("O tipo de endereço é obrigatório", mensagem);
	}

	@Test
	public void deveCriarUmaInstanciaEndereco() {
		Cliente cliente = Mockito.mock(Cliente.class);
		Cidade cidade = Mockito.mock(Cidade.class);
		String mensagem = null;
		try {
			endereco = new Endereco(cliente, "Avenida Center", "800", "00000-000", cidade, TipoEndereco.RESIDENCIAL,
					null);
		} catch (Exception e) {
			mensagem = e.getMessage();
		}
		Assert.assertNull(mensagem);
		Assert.assertEquals(cliente, endereco.getCliente());
		Assert.assertEquals("Avenida Center", endereco.getLogradouro());
		Assert.assertEquals("800", endereco.getNumero());
		Assert.assertEquals("00000-000", endereco.getCep());
		Assert.assertEquals(cidade, endereco.getCidade());
		Assert.assertEquals(TipoEndereco.RESIDENCIAL, endereco.getTipoEndereco());
		Assert.assertEquals(null, endereco.getComplemento());
	}
}
