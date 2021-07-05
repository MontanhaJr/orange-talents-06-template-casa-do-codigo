package br.com.zupacademy.mauricio.casadocodigo.validation.annotation.exists;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExistsValidate implements ConstraintValidator<ExistsValidator, Object> {

    private String nomeAtributo;
    private Class<?> classe;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(ExistsValidator validator) {
        nomeAtributo = validator.nomeAtributo();
        this.classe = validator.classe();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        Query query = entityManager.createQuery("SELECT 1 FROM " + classe.getName() + " WHERE " + nomeAtributo + " = :pNomeAtributo" );
        query.setParameter("pNomeAtributo", object);

        List<?> objeto = query.getResultList();

        return !objeto.isEmpty();
    }
}
