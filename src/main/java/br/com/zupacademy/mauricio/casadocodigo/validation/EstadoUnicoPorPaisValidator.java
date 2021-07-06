package br.com.zupacademy.mauricio.casadocodigo.validation;

import br.com.zupacademy.mauricio.casadocodigo.estado.Estado;
import br.com.zupacademy.mauricio.casadocodigo.estado.dto.request.EstadoRequest;
import br.com.zupacademy.mauricio.casadocodigo.estado.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class EstadoUnicoPorPaisValidator implements Validator {

    @Autowired
    EstadoRepository estadoRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return EstadoRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        EstadoRequest request = (EstadoRequest) target;

        Optional<Estado> estados = estadoRepository.findByNomeAndPais_id(request.getNome(), request.getId_pais());

        if (estados.isPresent()) {
            errors.rejectValue("nome", "EstadoUnicoNoPais");
        }
    }
}
