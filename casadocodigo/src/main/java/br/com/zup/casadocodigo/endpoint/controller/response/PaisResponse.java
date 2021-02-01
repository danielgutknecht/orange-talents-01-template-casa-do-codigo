package br.com.zup.casadocodigo.endpoint.controller.response;

import br.com.zup.casadocodigo.entities.Pais;

public class PaisResponse {

	private Long id;
	private String nome;

	public PaisResponse(Pais pais) {
		id = pais.getId();
		nome = pais.getNome();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

}
