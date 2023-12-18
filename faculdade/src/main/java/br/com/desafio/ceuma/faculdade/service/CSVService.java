package br.com.desafio.ceuma.faculdade.service;

import br.com.desafio.ceuma.faculdade.helper.CsvHelper;
import br.com.desafio.ceuma.faculdade.model.Aluno;
import br.com.desafio.ceuma.faculdade.model.Curso;
import br.com.desafio.ceuma.faculdade.repository.AlunoRepository;
import br.com.desafio.ceuma.faculdade.repository.CursoRepository;
import org.apache.commons.csv.CSVFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.util.List;

@Service
public class CSVService {

    @Autowired
    private CursoRepository cursosRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    public ByteArrayInputStream load(){
        List<Curso> cursos = cursosRepository.findAll();


        ByteArrayInputStream in = CsvHelper.cursoToCsv(cursos);
        return in;

    }


    public ByteArrayInputStream loadAluno(){
        List<Aluno> alunos = alunoRepository.findAll();

        ByteArrayInputStream in = CsvHelper.alunoToCsv(alunos);
        return in;
    }
}
