package br.com.zup.casadocodigo.endpoint.v1.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;
import com.sun.istack.NotNull;
import br.com.zup.casadocodigo.entities.Autor;
import br.com.zup.casadocodigo.entities.Categoria;
import br.com.zup.casadocodigo.entities.Livro;
import br.com.zup.casadocodigo.validations.Unique;

public class LivroRequest {

	@NotEmpty(message = "Nome não pode ser vazio.")
	@Length(min = 3, max = 200, message = "Nome deve conter entre 3 e 200 caracteres.")
	@Unique(domainClass = Livro.class, fieldName = "titulo", message = "{campo.titulo.repetido")
	private String titulo;
	@NotEmpty(message = "Nome não pode ser vazio.")
	@Length(min = 3, max = 200, message = "Nome deve conter entre 3 e 500 caracteres.")
	private String resumo;
	@NotEmpty(message = "Nome não pode ser vazio.")
	private String sumario;
	@NotEmpty(message = "Nome não pode ser vazio.")
	@Min(value = 20, message = "Preço mínimo é de 20")
	private BigDecimal preco;
	@Min(value = 100, message = "Valor mínimo é de 100 páginas")
	private Integer numeroPaginas;
	@NotEmpty(message = "Nome não pode ser vazio.")
	@Length(min = 3, max = 200, message = "Nome deve conter entre 3 e 200 caracteres.")
	@Unique(domainClass = Livro.class, fieldName = "isbn", message = "{campo.livro.repetido")
	private String isbn;
	private LocalDate dataPublicacao;
	@NotNull
	@NotEmpty
	private Long autor;	
	@NotNull
	@NotEmpty
	private Categoria categoria;
	

	public Livro toDamain(LivroRequest livroRequest) {
		return new Livro(
				titulo = livroRequest.getTitulo(), 
				resumo = livroRequest.getResumo(),
				sumario = livroRequest.getSumario(), 
				preco = livroRequest.getPreco(),
				numeroPaginas = livroRequest.getNumeroPaginas(), 
				isbn = livroRequest.getIsbn(),
				dataPublicacao = livroRequest.getDataPublicacao(),
				autor.
				);

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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Long getAutor() {
		return autor;
	}

	public void setAutor(Long autor) {
		this.autor = autor;
	}

	

}
