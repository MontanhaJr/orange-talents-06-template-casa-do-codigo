package br.com.zupacademy.mauricio.casadocodigo.autor.repository;

import br.com.zupacademy.mauricio.casadocodigo.autor.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    Optional<Autor> findByEmail(String email);
}
