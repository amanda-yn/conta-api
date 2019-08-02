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
import com.db1.conta.contaapi.domain.entity.Estado;
import com.db1.conta.contaapi.domain.entity.TipoEndereco;

@RunWith(SpringRunner.class)
@SpringBootTest	
public class ClienteRepositoryTest {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@After
	public void afterTest() {
		clienteRepository.deleteAll();
		cidadeRepository.deleteAll();
	}
	
	@Test
	public void deveSalvarUmNovoCliente() {
		Cliente cliente = new Cliente("Nome do Cliente", "99999999999");
		Cliente clienteSalva = clienteRepository.save(cliente);
		
		Assert.assertNotNull(clienteSalva);
		Assert.assertEquals(cliente.getCpf(), clienteSalva.getCpf());
		Assert.assertEquals(cliente.getNome(), clienteSalva.getNome());
	}
	
	@Test
	public void deveSalvarClienteComEndereco() {
		Cliente cliente = new Cliente("Nome do Cliente", "99999999999");
		Cidade cidade = cidadeRepository.save(new Cidade("Maringá", Estado.PR));
		
		cliente.addEndereco("Rua A", "99", "00000-000", cidade, TipoEndereco.COBRANCA, null);
		Cliente clienteSalvo = clienteRepository.save(cliente);
		
		Assert.assertEquals(cliente.getCpf(), clienteSalvo.getCpf());
		Assert.assertEquals(cliente.getNome(), clienteSalvo.getNome());
		Assert.assertEquals(1, clienteSalvo.getEnderecos().size());
		Assert.assertNotNull(clienteSalvo.getEnderecos().get(0).getId());
	}
}
