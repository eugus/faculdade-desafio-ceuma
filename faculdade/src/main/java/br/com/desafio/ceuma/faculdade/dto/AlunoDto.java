package br.com.desafio.ceuma.faculdade.dto;

import br.com.desafio.ceuma.faculdade.model.Aluno;

import javax.validation.constraints.NotBlank;

public class AlunoDto {

    private Long codigoAluno;

    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;

    @NotBlank
    private String cpf;
    @NotBlank
    private String endereco;
    @NotBlank
    private String cep;
    @NotBlank
    private  String email;
    @NotBlank
    private String telefone;

    private Long codigoCurso;


    public AlunoDto(Aluno alunos){
        codigoAluno = getCodigoAluno();
        nome = getNome();
        sobrenome = getSobrenome();
        cpf = getCpf();
        endereco = getEndereco();
        cep = getCep();
        email = getEmail();
        telefone = getTelefone();
        codigoCurso = alunos.getCursos().getCodigoCurso();

    }

    public AlunoDto(Long codigoAluno, String nome, String sobrenome, String cpf, String endereco, String cep, String email, String telefone, Long codigoCurso) {
        this.codigoAluno = codigoAluno;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.cep = cep;
        this.email = email;
        this.telefone = telefone;
        this.codigoCurso = codigoCurso;
    }

    public Long getCodigoAluno() {
        return codigoAluno;
    }

    public void setCodigoAluno(Long codigoAluno) {
        this.codigoAluno = codigoAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Long getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(Long codigoCurso) {
        this.codigoCurso = codigoCurso;
    }



}
