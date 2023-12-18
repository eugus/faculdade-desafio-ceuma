package br.com.desafio.ceuma.faculdade.service;

import br.com.desafio.ceuma.faculdade.dto.AlunoDto;
import br.com.desafio.ceuma.faculdade.model.Aluno;
import br.com.desafio.ceuma.faculdade.model.Curso;
import br.com.desafio.ceuma.faculdade.repository.AlunoRepository;
import br.com.desafio.ceuma.faculdade.service.exceptionsAluno.EntityAlunoNotFoundExceptions;
import br.com.desafio.ceuma.faculdade.service.exceptionsAluno.UnableToCreateEntityAluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;
    @Transactional(readOnly = true)
    public List<Aluno> findAll(){
        return alunoRepository.findAll();
    }
    //buscar por ID
    public Aluno buscarAlunoID(Long codigoAluno) {
        return alunoRepository.findById(codigoAluno).orElseThrow(
                () -> new EntityAlunoNotFoundExceptions("Código do aluno não encontrado, código:" + codigoAluno));
    }
    //criarAluno
    public AlunoDto criarAluno(AlunoDto alunosDto){
        Aluno entity = new Aluno();
        entity.setNome(alunosDto.getNome());
        entity.setSobrenome(alunosDto.getSobrenome());
        entity.setEmail(alunosDto.getEmail());
        entity.setCep(alunosDto.getCep());
        entity.setCpf(alunosDto.getCpf());
        entity.setTelefone(alunosDto.getTelefone());
        entity.setEndereco(alunosDto.getEndereco());
        Curso cursos = new Curso();
        cursos.setCodigoCurso(alunosDto.getCodigoCurso());
        entity.setCursos(cursos);
        Aluno dto = alunoRepository.save(entity);

        if (alunosDto.getNome() == ""){
            throw new UnableToCreateEntityAluno("Campo nome vazio");
        }
        if (alunosDto.getSobrenome() == ""){
            throw new UnableToCreateEntityAluno("Campo sobrenome vazio");
        }
        if (!alunosDto.getEmail().contains("@")){
            throw new UnableToCreateEntityAluno("Insira um e-mail válido");
        }
        if (alunosDto.getEmail() == ""){
            throw new UnableToCreateEntityAluno("Campo e-mail vazio");
        }
        if (alunosDto.getCep() == ""){
            throw new UnableToCreateEntityAluno("Campo cep vazio");
        }
        if (alunosDto.getCpf() == ""){
            throw new UnableToCreateEntityAluno("Campo cpf vazio");
        }
        if (alunosDto.getTelefone() == ""){
            throw new UnableToCreateEntityAluno("Campo telefone vazio");
        }
        if (alunosDto.getEndereco() == ""){
            throw new UnableToCreateEntityAluno("Campo endereço vazio");
        }
        alunosDto.setCodigoAluno(dto.getCodigoAluno());
        return alunosDto;
    }
    //atualizarAluno

    public AlunoDto atualizarAluno(AlunoDto alunosDto, Long codigoAluno){
        Aluno entity = alunoRepository.findById(codigoAluno).orElseThrow(
                () -> new EntityAlunoNotFoundExceptions("Código do aluno inválido "));
        //entity.setCodigoAluno(alunosDto.getCodigoAluno());
        entity.setNome(alunosDto.getNome());
        entity.setSobrenome(alunosDto.getSobrenome());
        entity.setEmail(alunosDto.getEmail());
        entity.setCep(alunosDto.getCep());
        entity.setCpf(alunosDto.getCpf());
        entity.setTelefone(alunosDto.getTelefone());
        entity.setEndereco(alunosDto.getEndereco());
        Aluno dto = alunoRepository.save(entity);
        alunosDto.setCodigoAluno(dto.getCodigoAluno());
        return alunosDto;
    }

    //excluir por ID
    public void excluirById(Long codigoAluno){
        alunoRepository.deleteById(codigoAluno);
    }
    //consulta paginada
    public Page<Aluno> findByPage(Pageable pageable){
        return alunoRepository.findAll(pageable);
    }




}
