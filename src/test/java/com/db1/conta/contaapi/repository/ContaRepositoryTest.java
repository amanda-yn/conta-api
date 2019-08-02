package com.db1.conta.contaapi.repository;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.db1.conta.contaapi.domain.entity.Agencia;
import com.db1.conta.contaapi.domain.entity.Cidade;
import com.db1.conta.contaapi.domain.entity.Cliente;
import com.db1.conta.contaapi.domain.entity.Conta;
import com.db1.conta.contaapi.domain.entity.Estado;
import com.db1.conta.contaapi.domain.entity.TipoConta;

@RunWith(SpringRunner.class)
@SpringBootTest	
public class ContaRepositoryTest{
	
	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private AgenciaRepository agenciaRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@After
	public void afterTest() {
		contaRepository.deleteAll();
		agenciaRepository.deleteAll();
		clienteRepository.deleteAll();
		cidadeRepository.deleteAll();
	}
	
	@Test
	public void deveSalvarUmaNovaConta() {
		Cidade cidade = cidadeRepository.save(new Cidade("Maringá", Estado.PR));
		Agencia agencia = agenciaRepository.save(new Agencia("001", "1", cidade));
		Cliente cliente = clienteRepository.save(new Cliente("Nome do cliente", "00000000000"));
		
		Conta conta = new Conta(agencia, "800000", TipoConta.CORRENTE, cliente, 8000.0);
		Conta contaSalva = contaRepository.save(conta);
		
		Assert.assertEquals(conta.getNumero(), contaSalva.getNumero());
		Assert.assertNotNull(conta.getId());
	}
}
