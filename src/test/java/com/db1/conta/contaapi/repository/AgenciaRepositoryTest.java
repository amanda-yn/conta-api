package com.db1.conta.contaapi.repository;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.db1.conta.contaapi.domain.entity.Agencia;
import com.db1.conta.contaapi.domain.entity.Cidade;
import com.db1.conta.contaapi.domain.entity.Estado;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AgenciaRepositoryTest {

	// Para cada repositório, tem que instanciar separadamente
	@Autowired
	private AgenciaRepository agenciaRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@After
	public void afterTest() {
		agenciaRepository.deleteAll();
		cidadeRepository.deleteAll();
	}

	@Test
	public void deveSalvarUmaAgencia() {
		Cidade cidade = cidadeRepository.save(new Cidade("Maringá", Estado.PR));
		Agencia agencia = new Agencia("001", "1", cidade);
		Agencia agenciaSalva = agenciaRepository.save(agencia);

		Assert.assertNotNull(agenciaSalva.getId());
		Assert.assertEquals(agencia.getNumero(), agenciaSalva.getNumero());
		Assert.assertEquals(agencia.getDigito(), agenciaSalva.getDigito());
	}

	@Test
	public void deveBuscarAgenciaPorNumero() {
		Cidade cidade = cidadeRepository.save(new Cidade("Maringá", Estado.PR));
		Agencia agencia = new Agencia("001", "1", cidade);
		agenciaRepository.save(agencia);

		Agencia agenciaBuscaPorNumero = agenciaRepository.findByNumero("001");

		Assert.assertNotNull(agenciaBuscaPorNumero);
		Assert.assertEquals(agencia.getNumero(), agenciaBuscaPorNumero.getNumero());
		Assert.assertEquals(agencia.getDigito(), agenciaBuscaPorNumero.getDigito());
		Assert.assertEquals(agencia.getCidade().getNome(), agenciaBuscaPorNumero.getCidade().getNome());
	}

	@Test
	public void deveBuscarAgenciaPorDigito() {
		Cidade cidade = cidadeRepository.save(new Cidade("Maringá", Estado.PR));
		Agencia agencia = new Agencia("001", "1", cidade);
		agenciaRepository.save(agencia);

		Agencia agenciaBuscaPorDigito = agenciaRepository.findByDigito("1");

		Assert.assertNotNull(agenciaBuscaPorDigito);
		Assert.assertEquals(agencia.getNumero(), agenciaBuscaPorDigito.getNumero());
		Assert.assertEquals(agencia.getDigito(), agenciaBuscaPorDigito.getDigito());
		Assert.assertEquals(agencia.getCidade().getNome(), agenciaBuscaPorDigito.getCidade().getNome());
	}

	@Test
	public void deveBuscarAgenciaPorEstado() {
		Cidade cidade = cidadeRepository.save(new Cidade("Maringá", Estado.PR));
		Agencia agencia = new Agencia("001", "1", cidade);
		agenciaRepository.save(agencia);

		List<Agencia> agencias = agenciaRepository.findByCidadeEstado(Estado.PR);
		Assert.assertEquals(1, agencias.size());
	}

}
