package br.com.zup.casadocodigo.endpoint.controller.request;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonFormat;
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
	@Min(value = 20, message = "Preço mínimo é de 20")
	private BigDecimal preco;
	@Min(value = 100, message = "Valor mínimo é de 100 páginas")
	private Integer numeroPaginas;
	@NotEmpty(message = "Nome não pode ser vazio.")
	@Length(min = 3, max = 200, message = "Nome deve conter entre 3 e 200 caracteres.")
	@Unique(domainClass = Livro.class, fieldName = "isbn", message = "{campo.livro.repetido")
	private String isbn;
	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	private LocalDate dataPublicacao;
	@NotNull
	@NotEmpty
	private Long autorId;
	@NotNull
	@NotEmpty
	private Long categoriaId;

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

	public Long getAutorId() {
		return autorId;
	}

	public Long getCategoriaId() {
		return categoriaId;
	}

}
