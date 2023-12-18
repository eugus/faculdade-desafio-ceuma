package br.com.desafio.ceuma.faculdade.repository;

import br.com.desafio.ceuma.faculdade.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
