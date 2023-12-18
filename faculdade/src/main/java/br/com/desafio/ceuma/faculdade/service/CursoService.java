package br.com.desafio.ceuma.faculdade.service;

import br.com.desafio.ceuma.faculdade.dto.CursoDto;
import br.com.desafio.ceuma.faculdade.model.Aluno;
import br.com.desafio.ceuma.faculdade.model.Curso;
import br.com.desafio.ceuma.faculdade.repository.CursoRepository;
import br.com.desafio.ceuma.faculdade.service.exceptionsCurso.EntityCursoNotFoundExceptions;
import br.com.desafio.ceuma.faculdade.service.exceptionsCurso.UnableToCreateEntityCurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;


    //GetAll
    @Transactional(readOnly = true) //fechar transação p/ leitura
    public List<Curso> findAll(){
        return cursoRepository.findAll();
    }

    //GetID
    public CursoDto buscarId(Long codigoCurso){
        Curso entity = cursoRepository.findById(codigoCurso).orElseThrow(
                () -> new EntityCursoNotFoundExceptions("Código do curso não encontrado, código: " + codigoCurso));
        CursoDto dto = new CursoDto(entity);
        return dto;
    }

    //Page
    public Page<Curso> findByPage(Pageable pageable){
        return cursoRepository.findAll(pageable);
    }


    //Post
    public CursoDto criarCurso(CursoDto cursoDto){
        Curso entity = new Curso();
        entity.setCodigoCurso(cursoDto.getCodigoCurso());
        entity.setNomeCurso(cursoDto.getNomeCurso());
        entity.setDataCadastro(LocalDateTime.now());
        entity.setCargaHoraria(cursoDto.getCargaHoraria());

        if (cursoDto.getNomeCurso() == "" && cursoDto.getCargaHoraria() != 0 ){
            throw new UnableToCreateEntityCurso("Preencha o campo nome do cursos");
        }
        if (cursoDto.getCargaHoraria() == 0 && cursoDto.getNomeCurso() != "") {
            throw new UnableToCreateEntityCurso("Preencha o campo carga horária");
        }
        if (cursoDto.getNomeCurso()== "" && cursoDto.getCargaHoraria() == 0 ){
            throw new UnableToCreateEntityCurso("Ops! Algum campo está vazio");
        }
        Curso dto = cursoRepository.save(entity);
        cursoDto.setCodigoCurso(dto.getCodigoCurso());
        return cursoDto;
    }

    //Update
    public CursoDto atualizarCurso(CursoDto cursoDto, Long codigoCurso){
        Curso entity = cursoRepository.findById(codigoCurso).orElseThrow(
                () -> new EntityCursoNotFoundExceptions("Código do curso inválido "));
        //entity.setCodigoCurso(cursoDto.getCodigoCurso());
        entity.setNomeCurso(cursoDto.getNomeCurso());
        entity.setDataCadastro(cursoDto.getDataCadastro());
        entity.setCargaHoraria(cursoDto.getCargaHoraria());
        Curso dto = cursoRepository.save(entity);
        cursoDto.setCodigoCurso(dto.getCodigoCurso());
        return cursoDto;
    }


    //teste outro update
    public Curso updateC(Curso cursos, Long codigoCurso){
        Curso entity = cursoRepository.getReferenceById(codigoCurso);
        entity.setCodigoCurso(cursos.getCodigoCurso());
        entity.setNomeCurso(cursos.getNomeCurso());
        //entity.setDataCadastro(LocalDateTime.parse(this.);
        entity.setCargaHoraria(cursos.getCargaHoraria());
        cursoRepository.save(entity);
        return entity;
    }


    //DeleteId
    public void excluirById(Long codigoCurso){
        cursoRepository.deleteById(codigoCurso);
    }




}
