package br.com.zupacademy.mauricio.casadocodigo.validation;

import br.com.zupacademy.mauricio.casadocodigo.form.AutorForm;
import br.com.zupacademy.mauricio.casadocodigo.model.Autor;
import br.com.zupacademy.mauricio.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class EmailUnicoValidator implements Validator {

    @Autowired
    AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return AutorForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }
        AutorForm request = (AutorForm) target;

        Optional<Autor> autor = autorRepository.findByEmail(request.getEmail());
        if (autor.isPresent()) {
            errors.rejectValue("email", "emailNotUnique", request.getEmail());
        }
    }
}
