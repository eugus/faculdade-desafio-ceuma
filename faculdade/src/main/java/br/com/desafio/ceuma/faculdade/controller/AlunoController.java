package br.com.desafio.ceuma.faculdade.controller;

import br.com.desafio.ceuma.faculdade.service.AlunoService;
import br.com.desafio.ceuma.faculdade.dto.AlunoDto;
import br.com.desafio.ceuma.faculdade.model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos2")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<Aluno>> getAlunos() {
        List<Aluno> obter = alunoService.findAll();
        return ResponseEntity.ok().body(obter);
    }

    @GetMapping("/{codigoAluno}")
    public ResponseEntity<Aluno> getAlunoID(@PathVariable Long codigoAluno){
        Aluno alunos = alunoService.buscarAlunoID(codigoAluno);
        return ResponseEntity.ok().body(alunos);
    }

    @GetMapping ("/page")
    public ResponseEntity<Page<Aluno>> getAlunopage(Pageable pageable) {
        Page<Aluno> page = alunoService.findByPage(pageable);
        return ResponseEntity.ok().body(page);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AlunoDto> insertAlunos(@RequestBody @Validated AlunoDto alunos){
        alunoService.criarAluno(alunos);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunos);
    }

    @PutMapping(value = "/{codigoAluno}")
    public ResponseEntity<AlunoDto> updateAluno(@RequestBody AlunoDto alunosDto, @PathVariable Long codigoAluno){
        alunoService.atualizarAluno(alunosDto, codigoAluno);
        return ResponseEntity.ok().body(alunosDto);
    }

    @DeleteMapping("/{codigoAluno}")
    public ResponseEntity deleteAluno(@PathVariable Long codigoAluno){
        alunoService.excluirById(codigoAluno);
        return ResponseEntity.status(HttpStatus.OK).body("Aluno excluído, código: " + codigoAluno);

    }


}
