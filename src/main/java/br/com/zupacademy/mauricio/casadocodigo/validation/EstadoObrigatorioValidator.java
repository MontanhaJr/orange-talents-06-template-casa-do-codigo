package br.com.zupacademy.mauricio.casadocodigo.validation;

import br.com.zupacademy.mauricio.casadocodigo.cliente.dto.request.ClienteRequest;
import br.com.zupacademy.mauricio.casadocodigo.estado.Estado;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class EstadoObrigatorioValidator implements Validator {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public boolean supports(Class<?> clazz) {
        return ClienteRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        ClienteRequest request = (ClienteRequest) target;

        Estado estadoNoPais = entityManager.find(Estado.class, request.getPais_id());

        if (request.getEstado_id() == null && estadoNoPais != null) {
            errors.rejectValue("estado_id", "EstadoObrigatorioNoPais");
        }
    }
}
