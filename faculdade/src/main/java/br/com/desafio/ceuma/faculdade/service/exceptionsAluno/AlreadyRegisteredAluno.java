package br.com.desafio.ceuma.faculdade.service.exceptionsAluno;

public class AlreadyRegisteredAluno extends RuntimeException{

    //exceção de quando o aluno ja está cadastrado, eu q tratei

    public AlreadyRegisteredAluno(String msg){
        super(msg);
    }
}
