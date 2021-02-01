package br.com.zup.casadocodigo.endpoint.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.zup.casadocodigo.endpoint.controller.request.LivroRequest;
import br.com.zup.casadocodigo.endpoint.controller.response.LivroResponse;
import br.com.zup.casadocodigo.services.LivroService;

@RestController
@RequestMapping("/api/livros")
public class LivroController {

	@Autowired
	LivroService livroService;

	@PostMapping
	public ResponseEntity<LivroResponse> createLivro(@RequestBody @Valid LivroRequest livroRequest) {
		return ResponseEntity.ok(livroService.criarLivro(livroRequest));
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<LivroResponse> findById(@PathVariable  Long id){
		return ResponseEntity.ok(livroService.buscaPorId(id));
	}
	
	@GetMapping
	public ResponseEntity<List<LivroResponse>> listarTodosLivros(){
		return ResponseEntity.ok(livroService.listarTodosLivros());
	}

}
