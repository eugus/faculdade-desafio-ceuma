package br.com.desafio.ceuma.faculdade.helper;

import br.com.desafio.ceuma.faculdade.model.Aluno;
import br.com.desafio.ceuma.faculdade.model.Curso;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.QuoteMode;
import org.apache.commons.csv.CSVPrinter;

public class CsvHelper {

    //csvPrinter -> printa os valores em csv
    //ByteArrayOutputStream mantém tudo o que você escreve em memória
    //csvFormat -> especifica o formato de um arquivo CSV para análise e gravação.

    public static ByteArrayInputStream cursoToCsv(List<Curso> cursos){
        final CSVFormat format = CSVFormat.EXCEL.withDelimiter(';');


        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out),format);){
            for (Curso cursos1 : cursos){
                List<String> data = Arrays.asList(
                        String.valueOf("códigoCurso: " + cursos1.getCodigoCurso()+ ""),
                        "nomeCurso: " + cursos1.getNomeCurso() + "",
                        String.valueOf("cargaHoraria: " + cursos1.getCargaHoraria()),
                        String.valueOf("dataCadastro: " + cursos1.getDataCadastro() ),
                        String.valueOf("Alunos: " + cursos1.getAlunos())
                );
                csvPrinter.printRecord(data);
            }
            csvPrinter.flush();
            return new ByteArrayInputStream(out.toByteArray());
        }catch (IOException e){
            throw new RuntimeException("falha para importar CSV" + e.getMessage());
        }
    }


    public static ByteArrayInputStream alunoToCsv(List<Aluno> alunos) {
        final CSVFormat format = CSVFormat.EXCEL.withDelimiter(';');

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
            for (Aluno alunos1 : alunos) {
                List<String> data = Arrays.asList(
                        ("Nome: " + alunos1.getNome() + ""),
                        ("Sobrenome: " + alunos1.getSobrenome()),
                        ("Cpf: " + alunos1.getCpf()),
                        ("Cep: " + alunos1.getCep()),
                        ("Email: " + alunos1.getEmail()),
                        ("Endereço: " + alunos1.getEndereco()),
                        ("Telefone: " + alunos1.getTelefone()),
                        ("Curso: " + alunos1.getCursos().toString())
                );
                csvPrinter.printRecord(data);
            }
            csvPrinter.flush();
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("falha para importar CSV" + e.getMessage());
        }
    }
}

