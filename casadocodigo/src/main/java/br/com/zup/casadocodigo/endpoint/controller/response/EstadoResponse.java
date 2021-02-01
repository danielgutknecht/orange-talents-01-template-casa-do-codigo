package br.com.zup.casadocodigo.endpoint.controller.response;

import br.com.zup.casadocodigo.entities.Estado;

public class EstadoResponse {

	private Long id;
	private String nome;
	private PaisResponse paisResponse;

	public EstadoResponse(Estado estado) {
		this.id = estado.getId();
		this.nome = estado.getNome();
		this.paisResponse = new PaisResponse(estado.getPais());
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public PaisResponse getPaisResponse() {
		return paisResponse;
	}

}
