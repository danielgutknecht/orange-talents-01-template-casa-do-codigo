package br.com.zup.casadocodigo.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@OneToMany(mappedBy = "pais", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Estado> estado = new HashSet<Estado>();

	public Pais() {

	}

	public Pais(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Set<Estado> getEstado() {
		return estado;
	}

}
