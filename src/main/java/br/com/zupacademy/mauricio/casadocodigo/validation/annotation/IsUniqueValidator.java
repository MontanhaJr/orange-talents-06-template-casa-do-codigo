package br.com.zupacademy.mauricio.casadocodigo.validation.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = UniqueValidator.class)
public @interface IsUniqueValidator {

    String message() default "já existe!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String nomeAtributo();

    Class<?> classe();

}