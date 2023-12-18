package br.com.desafio.ceuma.faculdade.service.exceptionsAluno;

public class UnableToCreateEntityAluno extends RuntimeException{


    //exceção quando campo está vazio (aluno)
    public UnableToCreateEntityAluno(String msg){
        super(msg);
    }
}
