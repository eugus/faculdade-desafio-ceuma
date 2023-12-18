package br.com.desafio.ceuma.faculdade.controller;

import br.com.desafio.ceuma.faculdade.service.CSVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/csv")
public class CSVController {

    @Autowired
    private CSVService csvService;

    @GetMapping("/cursos")
    public ResponseEntity<Resource> getFileCurso(){
        String filename = "cursos.csv";
        InputStreamResource file = new InputStreamResource(csvService.load());
        return  ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "anexo; nome do arquivo= " + filename)
                .contentType(MediaType.parseMediaType("application/csv"))
                .body(file);
    }

    @GetMapping("/alunos")
    public ResponseEntity<Resource> getFileAluno(){
        String filename = "alunos.csv";
        InputStreamResource file = new InputStreamResource(csvService.loadAluno());
        return  ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "anexo; nome do arquivo= " + filename)
                .contentType(MediaType.parseMediaType("application/csv"))
                .body(file);
    }
}
