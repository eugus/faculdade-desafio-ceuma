package br.com.desafio.ceuma.faculdade.controller;

import br.com.desafio.ceuma.faculdade.dto.CursoDto;
import br.com.desafio.ceuma.faculdade.model.Curso;
import br.com.desafio.ceuma.faculdade.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos2")
public class CursoController {

    @Autowired
    private CursoService cursoService;


    @GetMapping
    public ResponseEntity<List<Curso>> getCurso(){
        List<Curso> obter = cursoService.findAll();
        return ResponseEntity.ok().body(obter);
    }

    @GetMapping("{codigoCurso}")
    public ResponseEntity<CursoDto> getCursoID(@PathVariable Long codigoCurso){
        CursoDto cursos = cursoService.buscarId(codigoCurso);
        return ResponseEntity.ok().body(cursos);
    }

    @GetMapping ("/page")
    public ResponseEntity<Page<Curso>> getCursopage(Pageable pageable) {
        Page<Curso> page = cursoService.findByPage(pageable);
        return ResponseEntity.ok().body(page);
    }


    @PostMapping()
    public ResponseEntity<CursoDto> insertCurso(@RequestBody  CursoDto curso) {
        cursoService.criarCurso(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(curso);
    }

    @PutMapping("/{codigoCurso}")
    public ResponseEntity<CursoDto> updateCurso(@RequestBody CursoDto curso, @PathVariable Long codigoCurso) {
        cursoService.atualizarCurso(curso, codigoCurso);
        //System.out.println(curso.toString());
        //System.out.println(curso.);
        return ResponseEntity.status(HttpStatus.CREATED).body(curso);
    }

    /*@PutMapping(value = "/{codigoCurso}")
    public Curso update(@RequestBody Curso cursos, @PathVariable Long codigoCurso){
        return cursoService.updateC(cursos, codigoCurso);
    }

     */

    @DeleteMapping("/{codigoCurso}")
    public ResponseEntity excluirCurso(@PathVariable Long codigoCurso){
        cursoService.excluirById(codigoCurso);
        return ResponseEntity.status(HttpStatus.OK).body("Curso excluído, código =  " + codigoCurso);
    }




}
