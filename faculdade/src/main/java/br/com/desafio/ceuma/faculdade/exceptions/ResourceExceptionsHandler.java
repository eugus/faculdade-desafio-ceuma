package br.com.desafio.ceuma.faculdade.exceptions;

import br.com.desafio.ceuma.faculdade.service.exceptionsAluno.AlreadyRegisteredAluno;
import br.com.desafio.ceuma.faculdade.service.exceptionsAluno.EntityAlunoNotFoundExceptions;
import br.com.desafio.ceuma.faculdade.service.exceptionsAluno.UnableToCreateEntityAluno;
import br.com.desafio.ceuma.faculdade.service.exceptionsCurso.EntityCursoNotFoundExceptions;
import br.com.desafio.ceuma.faculdade.service.exceptionsCurso.UnableToCreateEntityCurso;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.validation.UnexpectedTypeException;
import java.time.Instant;

@ControllerAdvice // interceptar uma exceção específica, deixando o controller livre
public class ResourceExceptionsHandler {


    //exceção cursos

    @ExceptionHandler(UnableToCreateEntityCurso.class)
    public ResponseEntity<StandardErro> UnableToCreateAluno(UnableToCreateEntityCurso e, WebRequest request){
        StandardErro erro = new StandardErro();
        erro.setTimestamp(Instant.now());
        erro.setStatus(String.valueOf(HttpStatus.BAD_REQUEST.value()));
        erro.setError("Preencha todos os campos");
        erro.setMessage(e.getMessage());
        erro.setPath(request.getDescription(false));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    @ExceptionHandler(EntityCursoNotFoundExceptions.class)
    public ResponseEntity<StandardErro> EntityCursosNotFound(EntityCursoNotFoundExceptions e, WebRequest request){
        StandardErro erro = new StandardErro();
        erro.setTimestamp(Instant.now());
        erro.setStatus(String.valueOf(HttpStatus.NOT_FOUND.value()));
        erro.setError("Recurso não encontrado");
        erro.setMessage(e.getMessage());
        erro.setPath(request.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    //exceção alunos

    @ExceptionHandler(EntityAlunoNotFoundExceptions.class)
    public ResponseEntity<StandardErro> EntityAlunosNotFound(EntityAlunoNotFoundExceptions e, WebRequest request){
        StandardErro erro = new StandardErro();
        erro.setTimestamp(Instant.now());
        erro.setStatus(String.valueOf(HttpStatus.NOT_FOUND.value()));
        erro.setError("Recurso não encontrado");
        erro.setMessage(e.getMessage());
        erro.setPath(request.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(AlreadyRegisteredAluno.class)
    public ResponseEntity<StandardErro> AlreadyRegistered(AlreadyRegisteredAluno e, WebRequest request){
        StandardErro erro = new StandardErro();
        erro.setTimestamp(Instant.now());
        erro.setStatus(String.valueOf(HttpStatus.NOT_FOUND.value()));
        erro.setError("Impossível inserir o mesmo aluno");
        erro.setMessage(e.getMessage());
        erro.setPath(request.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(UnexpectedTypeException.class)
    public ResponseEntity<StandardErro> AlreadyRegistered(UnexpectedTypeException e, WebRequest request){
        StandardErro erro = new StandardErro();
        erro.setTimestamp(Instant.now());
        erro.setStatus(String.valueOf(HttpStatus.BAD_REQUEST.value()));
        erro.setError("Preencha todos os campos");
        erro.setMessage(e.getMessage());
        erro.setPath(request.getDescription(false));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }


    @ExceptionHandler(UnableToCreateEntityAluno.class)
    public ResponseEntity<StandardErro> UnableToCreateAluno(UnableToCreateEntityAluno e, WebRequest request) {
        StandardErro erro = new StandardErro();
        erro.setTimestamp(Instant.now());
        erro.setStatus(String.valueOf(HttpStatus.BAD_REQUEST.value()));
        erro.setError("Impossível criar aluno");
        erro.setMessage(e.getMessage());
        erro.setPath(request.getDescription(false));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }







}
