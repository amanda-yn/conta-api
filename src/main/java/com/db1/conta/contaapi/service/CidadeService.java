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
	
	public void delete(Long cidadeId) {
		Optional<Cidade> opCidade = cidadeRepository.findById(cidadeId);
		if(opCidade.isPresent()) {
			Cidade cidade = opCidade.get();
			cidadeRepository.delete(cidade);
		}
		throw new RuntimeException("Cidade ID " + cidadeId + "não encontrada");
	}
	
	public List<CidadeResponseDTO> buscarTodasCidades() {
		List<Cidade> cidades = cidadeRepository.findAll();
		Assert.notEmpty(cidades, "Cidades não encontradas");
		List<CidadeResponseDTO> response = CidadeAdapter.entityToResponse(cidades);
		return response;
	}
	
	public CidadeResponseDTO buscarCidadePorId(Long cidadeId) {
		Optional<Cidade> opCidade = cidadeRepository.findById(cidadeId);
		if(opCidade.isPresent()) {
			Cidade cidade = opCidade.get();
			return CidadeAdapter.entityToResponse(cidade);
		}
		throw new RuntimeException("Cidade ID " + cidadeId + "não encontrada");
	}
	 
	public CidadeResponseDTO buscarCidadePorNome(String nome) { //Java 8
		Optional<Cidade> opCidade = cidadeRepository.findByNomeOptional(nome);
		if(opCidade.isPresent()) {
			Cidade cidade = opCidade.get();
			CidadeResponseDTO cidadeResponse = CidadeAdapter.entityToResponse(cidade);
			return cidadeResponse;
		}
		throw new RuntimeException("Cidade " + nome + "não encontrada");
		
//		return cidadeRepository
//				.findByNomeOptional(nome)
//				.map(CidadeAdapter::entityToResponse)
//				.orElseThrow(() -> 
//					new RuntimeException("Cidade de nome " + nome + " não  encontrada"));
	}
}
