package br.com.zup.casadocodigo.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.zup.casadocodigo.endpoint.controller.request.EstadoRequest;

@Entity
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pais_id", nullable = false)
	private Pais pais;

	public Estado() {

	}

	public Estado(String nome) {
		this.nome = nome;
	}

	public Estado(EstadoRequest request, Pais pais) {
		this.nome = request.getNome();
		this.pais = pais;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Pais getPais() {
		return pais;
	}
	
	public boolean pertenceAoPais(Pais pais) {
        return this.pais.equals(pais);
    }

}
