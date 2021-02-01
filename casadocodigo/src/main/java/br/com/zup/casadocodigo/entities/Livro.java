package br.com.zup.casadocodigo.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import br.com.zup.casadocodigo.endpoint.controller.request.LivroRequest;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal preco;
	private Integer numeroPaginas;
	private String isbn;
	private LocalDate dataPublicacao;

	@ManyToOne
	private Autor autor;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	private Categoria categoria;

	public Livro() {

	}

	public Livro(LivroRequest request, Autor autor, Categoria categoria) {

		this.titulo = request.getTitulo();
		this.resumo = request.getResumo();
		this.sumario = request.getSumario();
		this.preco = request.getPreco();
		this.numeroPaginas = request.getNumeroPaginas();
		this.isbn = request.getIsbn();
		this.dataPublicacao = request.getDataPublicacao();
		this.autor = autor;
		this.categoria = categoria;

	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public Autor getAutor() {
		return autor;
	}

	public Categoria getCategoria() {
		return categoria;
	}

}
