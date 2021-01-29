package br.com.zup.casadocodigo.endpoint.v1.dto.response;

import br.com.zup.casadocodigo.entities.Categoria;

public class CategoriaResponse {

	private Long id;
	private String nome;
	
	public CategoriaResponse() {
		
	}

	public CategoriaResponse(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public CategoriaResponse toModel(Categoria categoria) {
		return new CategoriaResponse(id = categoria.getId(), nome = categoria.getNome());
		
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
