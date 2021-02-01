package br.com.zup.casadocodigo.endpoint.controller.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import br.com.zup.casadocodigo.entities.Livro;

public class LivroResponse {

	private Long id;
	private String titulo;
	private String resumo;
	private String sumario;
	private BigDecimal preco;
	private Integer numeroPaginas;
	private String isbn;
	private LocalDate dataPublicacao;
	private Long autor;
	private AutorResponse autorResponse;
	private Long categoria;
	private CategoriaResponse categoriaResponse;

	public LivroResponse(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.numeroPaginas = livro.getNumeroPaginas();
		this.isbn = livro.getIsbn();
		this.dataPublicacao = livro.getDataPublicacao();
		this.autor = livro.getAutor().getId();
		this.categoria = livro.getCategoria().getId();
		this.autorResponse = new AutorResponse(livro.getAutor());
		this.categoriaResponse = new CategoriaResponse(livro.getCategoria());
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

	public Long getAutor() {
		return autor;
	}

	public AutorResponse getAutorResponse() {
		return autorResponse;
	}

	public Long getCategoria() {
		return categoria;
	}

	public CategoriaResponse getCategoriaResponse() {
		return categoriaResponse;
	}

}
