package br.com.desafio.ceuma.faculdade.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "cursos")
public class Curso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoCurso;
    private String nomeCurso;
    private LocalDateTime dataCadastro;
    private int cargaHoraria;

    @OneToMany(mappedBy = "cursos")
    private List<Aluno> alunos = new ArrayList<>();



    public Curso(Long codigoCurso, String nomeCurso, LocalDateTime dataCadastro, int cargaHoraria) {
        this.codigoCurso = codigoCurso;
        this.nomeCurso = nomeCurso;
        this.dataCadastro = dataCadastro;
        this.cargaHoraria = cargaHoraria;
    }

    public Curso() {
    }


    public Long getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(Long codigoCurso) {
        this.codigoCurso = codigoCurso;
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

    public List<Aluno> getAlunos() {
        return alunos;
    }

   


}
