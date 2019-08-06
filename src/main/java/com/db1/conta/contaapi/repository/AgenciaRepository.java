package com.db1.conta.contaapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db1.conta.contaapi.domain.entity.Agencia;
import com.db1.conta.contaapi.domain.entity.Estado;

public interface AgenciaRepository extends JpaRepository< Agencia, Long> {
	Agencia findByNumero(String numero);
	Agencia findByDigito(String digito);
	
	//Busca na coluna Cidade as cidades por Estado
	List<Agencia> findByCidadeEstado (Estado estado); 
}