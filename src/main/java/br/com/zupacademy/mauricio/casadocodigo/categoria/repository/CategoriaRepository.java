package br.com.zupacademy.mauricio.casadocodigo.categoria.repository;

import br.com.zupacademy.mauricio.casadocodigo.categoria.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Optional<Categoria> findByNome(String nome);
}
