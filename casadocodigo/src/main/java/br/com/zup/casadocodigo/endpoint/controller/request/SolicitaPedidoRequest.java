package br.com.zup.casadocodigo.endpoint.controller.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SolicitaPedidoRequest {

	@NotBlank(message = "O email é obrigatório")
	@Email(message = "Formato de email inválido")
	private String email;
	@NotBlank(message = "O nome é obrigatório")
	private String nome;
	@NotBlank(message = "O sobrenome é obrigatório")
	private String sobrenome;
	@NotBlank(message = "O documento é obrigatório")
	// @CpfOuCnpj(message = "CPF/CNPJ inválido")
	private String documento;
	@NotBlank(message = "O endereço é obrigatório")
	private String endereco;
	@NotBlank(message = "O complemento é obrigatório")
	private String complemento;
	@NotBlank(message = "A cidade é obrigatório")
	private String cidade;
	@NotNull
	@NotBlank
	private Long pais;
	@NotNull
	@NotBlank
	private Long estado;
	@NotBlank(message = "O telefone é obrigatório")
	private String telefone;
	@NotBlank(message = "O cep é obrigatório")
	private String cep;

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public Long getPais() {
		return pais;
	}

	public Long getEstado() {
		return estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}

	@Override
	public String toString() {
		return "PedidoRequest [email=" + email + ", nome=" + nome + ", sobrenome=" + sobrenome + ", documento="
				+ documento + ", endereco=" + endereco + ", complemento=" + complemento + ", cidade=" + cidade
				+ ", pais=" + pais + ", estado=" + estado + ", telefone=" + telefone + ", cep=" + cep + "]";
	}

}
