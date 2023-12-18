package br.com.desafio.ceuma.faculdade.service.exceptionsAluno;

public class EntityAlunoNotFoundExceptions extends RuntimeException {

    //exceção quando não foi encontrada id do aluno, eu q tratei


    public EntityAlunoNotFoundExceptions(String msg){
        super(msg);
    }


}
