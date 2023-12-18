package br.com.desafio.ceuma.faculdade.service.exceptionsCurso;

public class EntityCursoNotFoundExceptions extends RuntimeException{

    //quando id curso nao existir, eu q tratei
    public EntityCursoNotFoundExceptions(String msg){
        super(msg);
    }
}
