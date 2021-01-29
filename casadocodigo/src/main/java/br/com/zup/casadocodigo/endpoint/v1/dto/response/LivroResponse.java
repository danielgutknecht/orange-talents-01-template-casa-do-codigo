package br.com.zup.casadocodigo.endpoint.v1.dto.response;

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

	public LivroResponse() {

	}

	public LivroResponse(Long id, String titulo, String resumo, String sumario, BigDecimal preco, Integer numeroPaginas,
			String isbn, LocalDate dataPublicacao, Long autor) {
		this.id = id;
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.autor = autor;
	}

	public LivroResponse toModel(Livro livro) {
		return new LivroResponse(
				id = livro.getId(), 
				titulo = livro.getTitulo(), 
				resumo = livro.getResumo(),
				sumario = livro.getResumo(), 
				preco = livro.getPreco(), 
				numeroPaginas = livro.getNumeroPaginas(),
				isbn = livro.getIsbn(), 
				dataPublicacao = livro.getDataPublicacao(),
				autor = livro.getId()
				);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public void setSumario(String sumario) {
		this.sumario = sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public Long getAutor() {
		return autor;
	}

	public void setAutor(Long autor) {
		this.autor = autor;
	}

}
