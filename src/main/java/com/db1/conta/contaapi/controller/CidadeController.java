package com.db1.conta.contaapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.db1.conta.contaapi.domain.dto.CidadePersistDTO;
import com.db1.conta.contaapi.domain.dto.CidadeResponseDTO;
import com.db1.conta.contaapi.service.CidadeService;

//Requisições REST

@RestController //API REST
@RequestMapping("/api/cidades") //MAPEAMENTO 
public class CidadeController {
	
	@Autowired
	private CidadeService cidadeService;
	
	@GetMapping("/todas-cidades")
	public List<CidadeResponseDTO> todasCidades(){
		return cidadeService.buscarTodasCidades();
	}
	
	@GetMapping						// Exemplo: ?nome=Maringa
	public CidadeResponseDTO buscarCidadePorNome(@RequestParam("nome") String nome) { //Quando utilizar Request Param
		return cidadeService.buscarCidadePorNome(nome);
	}
	
	@GetMapping("/{id}")			// Exemplo : 5
	public CidadeResponseDTO buscarCidadePorId(@PathVariable("id") Long id) { //Quando utilizar Path Variable
		return cidadeService.buscarCidadePorId(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED) //CREATED é o código 201 
	public CidadeResponseDTO salvar(@RequestBody CidadePersistDTO body) {
		return cidadeService.save(body);
	}
	
	@PutMapping("/{id}") 
	public CidadeResponseDTO atualizar(@PathVariable("id") Long id, @RequestBody CidadePersistDTO body) {
		return cidadeService.update(id, body);
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable("id") Long id) {
		cidadeService.delete(id);
	}
	
}
