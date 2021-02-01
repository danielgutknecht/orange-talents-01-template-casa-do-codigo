package br.com.zup.casadocodigo.endpoint.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.zup.casadocodigo.endpoint.controller.request.PaisRequest;
import br.com.zup.casadocodigo.endpoint.controller.response.PaisResponse;
import br.com.zup.casadocodigo.entities.Pais;
import br.com.zup.casadocodigo.repositories.PaisRepository;

@RestController
@RequestMapping("/api/paises")
public class PaisController {

	@Autowired
	private PaisRepository paisRepository;

	@PostMapping
	public ResponseEntity<PaisResponse> createPais(@RequestBody @Valid PaisRequest paisRequest) {
		Pais pais = paisRequest.toDomain(paisRequest);
		paisRepository.save(pais);
		return ResponseEntity.ok(new PaisResponse(pais));
	}

}
