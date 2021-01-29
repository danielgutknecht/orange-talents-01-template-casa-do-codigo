package br.com.zup.casadocodigo.endpoint.v1.dto.request;

import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;
import br.com.zup.casadocodigo.entities.Categoria;
import br.com.zup.casadocodigo.validations.Unique;

public class CategoriaRequest {

	@NotEmpty(message = "Nome não pode ser vazio.")
	@Length(min = 3, max = 200, message = "Nome deve conter entre 3 e 200 caracteres.")
	@Unique(domainClass = Categoria.class, fieldName = "nome", message = "{campo.nome.repetido")
	private String nome;

	public Categoria toDomain(CategoriaRequest categoriaRequest) {
		return new Categoria(nome = categoriaRequest.getNome());
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
