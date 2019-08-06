package com.db1.conta.contaapi.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.db1.conta.contaapi.adapter.CidadeAdapter;
import com.db1.conta.contaapi.domain.dto.CidadePersistDTO;
import com.db1.conta.contaapi.domain.dto.CidadeResponseDTO;
import com.db1.conta.contaapi.domain.entity.Cidade;
import com.db1.conta.contaapi.repository.CidadeRepository;

@Service
public class CidadeService { //Processo de chamar os repositorios
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public CidadeResponseDTO save(CidadePersistDTO dto) {
		Cidade cidade = new Cidade(dto.getNome(), dto.getEstado());
		cidadeRepository.save(cidade);
		return CidadeAdapter.entityToResponse(cidade);
	}
	
	public CidadeResponseDTO update(Long cidadeId, CidadePersistDTO dto) {
		//Devolve uma cidade encapsulada do tipo optional
		Cidade cidade = cidadeRepository.findById(cidadeId).orElseThrow(() -> new RuntimeException("Cidade ID " + 
		cidadeId + "não encontrada"));
		cidade.alterarCidade(dto.getNome(), dto.getEstado());
		cidadeRepository.save(cidade);
		return CidadeAdapter.entityToResponse(cidade);
	}
	
	public void delete(Long cidadeId, CidadePersistDTO dto) {
		Optional<Cidade> opCidade = cidadeRepository.findById(cidadeId);
		if(opCidade.isPresent()) {
			Cidade cidade = opCidade.get();
			cidade.alterarCidade(dto.getNome(), dto.getEstado());
			cidadeRepository.delete(cidade);
		}
		throw new RuntimeException("Cidade ID " + cidadeId + "não encontrada");
	}
	
	public List<Cidade> buscarCidades() {
		List<Cidade> listCidade = cidadeRepository.findAll();
		Assert.notEmpty(listCidade, "Cidades não encontradas");
		return listCidade;
	}
	
	public Cidade buscarCidadePorId(Long cidadeId) {
		Cidade cidade = cidadeRepository.findById(cidadeId).orElseThrow(() -> new RuntimeException("Cidade ID " +
		cidadeId + "não encontrada"));
		return cidade;
	}
	 
	public Cidade buscarCidadePorNome(String nomeCidade) {
		Cidade cidade = cidadeRepository.findByNome(nomeCidade);
		Assert.notNull(cidade, "Cidade " + nomeCidade + "não encontrada");
		return cidade;
	}
}
