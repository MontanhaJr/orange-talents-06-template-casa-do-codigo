package br.com.zupacademy.mauricio.casadocodigo.repository;

import br.com.zupacademy.mauricio.casadocodigo.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
}
