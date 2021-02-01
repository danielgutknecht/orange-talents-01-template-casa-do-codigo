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
import br.com.zup.casadocodigo.endpoint.controller.request.AutorRequest;
import br.com.zup.casadocodigo.endpoint.controller.response.AutorResponse;
import br.com.zup.casadocodigo.entities.Autor;
import br.com.zup.casadocodigo.repositories.AutorRepository;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

	@Autowired
	private AutorRepository autorRepository;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<AutorResponse> criarNovoAutor(@RequestBody @Valid AutorRequest autorRequest) {
		Autor autor = autorRequest.toDomain(autorRequest);
		autorRepository.save(autor);
		return ResponseEntity.ok().body(new AutorResponse(autor));
	}

}
