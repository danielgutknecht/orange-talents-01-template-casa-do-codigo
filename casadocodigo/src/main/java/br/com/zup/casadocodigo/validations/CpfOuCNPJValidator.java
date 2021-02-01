package br.com.zup.casadocodigo.validations;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import br.com.zup.casadocodigo.endpoint.controller.request.SolicitaPedidoRequest;


public class CpfOuCNPJValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return SolicitaPedidoRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		if (errors.hasErrors()) {
			return;
		}

		SolicitaPedidoRequest request = (SolicitaPedidoRequest) target;

		CNPJValidator cnpjValidator = new CNPJValidator();
		cnpjValidator.initialize(null);

		CPFValidator cpfValidator = new CPFValidator();
		cpfValidator.initialize(null);

		String document = request.getDocumento();

		if (cnpjValidator.isValid(document, null) || cpfValidator.isValid(document, null)) {
			return;
		}

		errors.rejectValue("Documento", "Documento não é válido");

	}
}