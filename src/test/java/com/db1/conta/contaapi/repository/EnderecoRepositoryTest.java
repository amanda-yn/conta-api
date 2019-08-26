package com.db1.conta.contaapi.repository;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.db1.conta.contaapi.domain.entity.Cidade;
import com.db1.conta.contaapi.domain.entity.Cliente;
import com.db1.conta.contaapi.domain.entity.Endereco;
import com.db1.conta.contaapi.domain.entity.Estado;
import com.db1.conta.contaapi.domain.entity.TipoEndereco;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EnderecoRepositoryTest {

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@After
	public void AfterTest() {
		enderecoRepository.deleteAll();
		clienteRepository.deleteAll();
		cidadeRepository.deleteAll();
	}

	@Test
	public void deveSalvarUmEnderecoEmUmCliente() {
		Cidade cidade = cidadeRepository.save(new Cidade("Maringá", Estado.PR));
		Cliente cliente = clienteRepository.save(new Cliente("Nome do cliente", "00000000000"));

		Endereco endereco = new Endereco(cliente, "Rua 001", "999", "00000-000", cidade, TipoEndereco.RESIDENCIAL, null);
		Endereco enderecoSalva = enderecoRepository.save(endereco);

		Assert.assertEquals(endereco.getLogradouro(), enderecoSalva.getLogradouro());
		Assert.assertEquals(endereco.getNumero(), enderecoSalva.getNumero());
		Assert.assertEquals(endereco.getCep(), enderecoSalva.getCep());
		Assert.assertEquals(endereco.getTipoEndereco(), enderecoSalva.getTipoEndereco());
		Assert.assertEquals(endereco.getComplemento(), enderecoSalva.getComplemento());
		Assert.assertNotNull(endereco.getId());
	}
}
