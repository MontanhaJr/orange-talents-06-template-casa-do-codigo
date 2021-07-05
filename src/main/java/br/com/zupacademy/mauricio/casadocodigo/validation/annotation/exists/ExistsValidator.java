package br.com.zupacademy.mauricio.casadocodigo.validation.annotation.exists;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = ExistsValidate.class)
public @interface ExistsValidator {

    String message() default "Não existe!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String nomeAtributo();

    Class<?> classe();
}
