package br.com.zup.casadocodigo.endpoint.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.casadocodigo.endpoint.v1.dto.request.LivroRequest;
import br.com.zup.casadocodigo.endpoint.v1.dto.response.LivroResponse;
import br.com.zup.casadocodigo.entities.Livro;
import br.com.zup.casadocodigo.repositories.LivroRepository;

@RestController
@RequestMapping("/api/livros")
public class LivroController {
	
	@Autowired
	LivroRepository livroRepository;
	
	@PostMapping
	public ResponseEntity<LivroResponse> createLivro(@RequestBody @Valid LivroRequest livroRequest){
		
		Livro livro = livroRequest.toDamain(livroRequest);
		
		livroRepository.save(livro);
		
		return ResponseEntity.ok().body(new LivroResponse().toModel(livro));
		
		
	}

}
