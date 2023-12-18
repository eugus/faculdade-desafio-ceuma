package br.com.desafio.ceuma.faculdade.dto;

import br.com.desafio.ceuma.faculdade.model.Curso;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

public class CursoDto {

    private Long codigoCurso;
    private String nomeCurso;

    private LocalDateTime dataCadastro ;
    private int cargaHoraria;



    public CursoDto(Curso cursos){
        codigoCurso = cursos.getCodigoCurso();
        nomeCurso = cursos.getNomeCurso();
        dataCadastro = cursos.getDataCadastro();
        cargaHoraria = cursos.getCargaHoraria();
    }

    public CursoDto(Long codigoCurso, String nomeCurso, LocalDateTime dataCadastro, int cargaHoraria){
        this.codigoCurso = codigoCurso;
        this.nomeCurso = nomeCurso;
        this.dataCadastro = dataCadastro = LocalDateTime.now();
        this.cargaHoraria = cargaHoraria;
    }

    public void setCodigoCurso(Long codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public Long getCodigoCurso() {
        return codigoCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

}
