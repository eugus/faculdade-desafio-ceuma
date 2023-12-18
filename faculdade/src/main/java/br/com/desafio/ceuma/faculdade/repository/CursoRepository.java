package br.com.desafio.ceuma.faculdade.repository;

import br.com.desafio.ceuma.faculdade.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
