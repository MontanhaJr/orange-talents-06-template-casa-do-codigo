package br.com.zupacademy.mauricio.casadocodigo.estado.repository;

import br.com.zupacademy.mauricio.casadocodigo.estado.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
    Optional<Estado> findByNomeAndPais_id(String nome, Long id_pais);
}
