package br.com.zup.casadocodigo.validations;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class UniqueValidator implements ConstraintValidator<Unique, Object>{
	
	private String fieldName;
	private Class<?> domainClass;

	@PersistenceContext
	private EntityManager manager;

	public UniqueValidator(EntityManager manager) {
	        this.manager = manager;
	    }

	@Override
	public void initialize(Unique constraintAnnotation) {
		this.fieldName = constraintAnnotation.fieldName();
		this.domainClass = constraintAnnotation.domainClass();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Query query = manager
				.createQuery("Select 1 from " + domainClass.getSimpleName() + " where " + fieldName + " =:value");
		query.setParameter("value", value);
		List<?> list = query.getResultList();
		Assert.state(list.size() < 1, "Foram encontrados mais de um(a) " + domainClass.getSimpleName()
				+ " com o mesmo '" + fieldName + "'" + value);
		return list.isEmpty();
	}

}
