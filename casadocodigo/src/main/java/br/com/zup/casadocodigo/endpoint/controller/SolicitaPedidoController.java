package br.com.zup.casadocodigo.endpoint.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.zup.casadocodigo.endpoint.controller.request.SolicitaPedidoRequest;
import br.com.zup.casadocodigo.validations.CpfOuCNPJValidator;
import br.com.zup.casadocodigo.validations.EstadoPertencePaisValidator;


@RestController
@RequestMapping("/api/solicitapedidos")
public class SolicitaPedidoController {

	@Autowired
	private EstadoPertencePaisValidator estadoPertencePaisValidator;

	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(new CpfOuCNPJValidator());
		binder.addValidators(estadoPertencePaisValidator);
	}

	@PostMapping
	public String solicitaNovoPedido(@RequestBody @Valid SolicitaPedidoRequest request) {
		return request.toString();
	}

}
