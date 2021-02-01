package br.com.zup.casadocodigo.endpoint.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.com.zup.casadocodigo.endpoint.controller.request.CategoriaRequest;
import br.com.zup.casadocodigo.endpoint.controller.response.CategoriaResponse;
import br.com.zup.casadocodigo.entities.Categoria;
import br.com.zup.casadocodigo.repositories.CategoriaRepository;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<CategoriaResponse> criarCategoria(@RequestBody @Valid CategoriaRequest categoriaRequest) {
		Categoria categoria = categoriaRequest.toDomain(categoriaRequest);
		categoriaRepository.save(categoria);
		return ResponseEntity.ok().body(new CategoriaResponse(categoria));
	}

}
