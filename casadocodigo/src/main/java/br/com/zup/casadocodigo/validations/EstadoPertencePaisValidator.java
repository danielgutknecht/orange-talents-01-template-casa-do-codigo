package br.com.zup.casadocodigo.validations;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import br.com.zup.casadocodigo.endpoint.controller.request.SolicitaPedidoRequest;
import br.com.zup.casadocodigo.entities.Estado;
import br.com.zup.casadocodigo.entities.Pais;
import br.com.zup.casadocodigo.repositories.EstadoRepository;
import br.com.zup.casadocodigo.repositories.PaisRepository;

@Component
public class EstadoPertencePaisValidator implements Validator{

	@Autowired
	private PaisRepository paisRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	public boolean supports(Class<?> clazz) {
		return SolicitaPedidoRequest.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		SolicitaPedidoRequest request = (SolicitaPedidoRequest) target;

		Optional<Pais> optionalPais = paisRepository.findById(request.getPais());
		Optional<Estado> optionalEstado = estadoRepository.findById(request.getEstado());

		if (optionalPais.isEmpty()) {
			errors.rejectValue("paisId", "Pais não encontrado.");
			return;
		}

		Pais paisId = optionalPais.get();

		if (optionalPais.isEmpty() || !optionalEstado.get().pertenceAoPais(paisId)) {
			errors.rejectValue("estadoId", "Estado não encontrado");
		}
	}

	
}
