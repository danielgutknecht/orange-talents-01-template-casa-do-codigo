package br.com.zup.casadocodigo.endpoint.controller;

import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import br.com.zup.casadocodigo.endpoint.controller.request.EstadoRequest;
import br.com.zup.casadocodigo.endpoint.controller.response.EstadoResponse;
import br.com.zup.casadocodigo.entities.Estado;
import br.com.zup.casadocodigo.entities.Pais;
import br.com.zup.casadocodigo.repositories.EstadoRepository;
import br.com.zup.casadocodigo.repositories.PaisRepository;

@RestController
@RequestMapping("/api/estados")
public class EstadoController {

	@Autowired
	private PaisRepository paisRepository;
	@Autowired
	private EstadoRepository estadoRepository;

	@PostMapping
	public ResponseEntity<EstadoResponse> createEstado(@RequestBody @Valid EstadoRequest request) {
		Long paisId = request.getPaisId();
		
		Optional<Pais> optionalPais = paisRepository.findById(paisId);
		if (optionalPais.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID do país não foi encontrado");
		}

		Estado estado = new Estado(request, optionalPais.get());

		estadoRepository.save(estado);

		return ResponseEntity.ok(new EstadoResponse(estado));

	}

}
