package br.com.zup.casadocodigo.endpoint.v1.dto.response;

import br.com.zup.casadocodigo.entities.Autor;

public class AutorResponse {

	private Long id;
	private String nome;
	private String email;
	private String descricao;

	public AutorResponse() {
		
	}

	public AutorResponse(Long id, String nome, String email, String descricao) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;

	}

	public AutorResponse toModel(Autor autor) {
		return new AutorResponse(
				id = autor.getId(), 
				nome = autor.getNome(), 
				email = autor.getEmail(),
				descricao = autor.getDescricao());
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

}
