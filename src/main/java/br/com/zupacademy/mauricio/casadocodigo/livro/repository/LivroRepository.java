package br.com.zupacademy.mauricio.casadocodigo.livro.repository;

import br.com.zupacademy.mauricio.casadocodigo.livro.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
}
