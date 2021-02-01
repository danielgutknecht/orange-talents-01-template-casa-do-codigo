package br.com.zup.casadocodigo.endpoint.controller.request;

import br.com.zup.casadocodigo.entities.Pais;

public class PaisRequest {

	private String nome;

	public Pais toDomain(PaisRequest request) {
		return new Pais(nome = request.getNome());
	}

	public String getNome() {
		return nome;
	}

}
