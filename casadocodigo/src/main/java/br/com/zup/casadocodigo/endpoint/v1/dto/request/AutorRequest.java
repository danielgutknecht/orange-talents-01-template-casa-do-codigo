package br.com.zup.casadocodigo.endpoint.v1.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.NonNull;
import br.com.zup.casadocodigo.entities.Autor;
import br.com.zup.casadocodigo.validations.Unique;

public class AutorRequest {

	@NotEmpty(message = "Nome não pode ser vazio.")
	@Length(min = 3, max = 200, message = "Nome deve conter entre 3 e 200 caracteres.")
	private String nome;
	@Email(message = "E-mail inválido. ")
	@Unique(domainClass = Autor.class, fieldName = "email", message = "{campo.email.repetido")
	private String email;
	@NotEmpty(message = "Descrição não pode ser vazio.")
	@Length(min = 3, max = 400, message = "Nome deve conter entre 3 e 200 caracteres.")
	private String descricao;

	public Autor toDomain(AutorRequest autorRequest) {
		return new Autor(
				nome = autorRequest.nome, 
				email = autorRequest.email, 
				descricao = autorRequest.descricao
				);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
