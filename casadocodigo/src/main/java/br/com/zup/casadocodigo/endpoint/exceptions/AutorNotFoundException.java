package br.com.zup.casadocodigo.endpoint.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Autor não foi encontrado.")
public class AutorNotFoundException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public AutorNotFoundException(String mensagem) {
		super(mensagem);
	}

	public AutorNotFoundException(Long id) {
		this(String.format("Autor com ID: %d não existe ", id));
	}

}
