package com.db1.conta.contaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db1.conta.contaapi.domain.entity.Cidade;
import com.db1.conta.contaapi.domain.entity.Cliente;
import com.db1.conta.contaapi.domain.entity.Endereco;

public interface EnderecoRepository extends JpaRepository< Endereco, Long> {
	Endereco findByCliente (Cliente cliente);
	Endereco findByLogradouro (String logradouro);
	Endereco findByNumero (String Numero);
	Endereco findByCep (String cep);
	Endereco findByComplemento (String complemento);
	List<Endereco> findByCidade (Cidade cidade);
}
