package br.com.desafio.ceuma.faculdade.controller;

import br.com.desafio.ceuma.faculdade.model.Curso;
import br.com.desafio.ceuma.faculdade.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CursoFrontController {

    @Autowired
    private CursoRepository cursoRepository;

    @RequestMapping(value = "/cadastrarCurso", method = RequestMethod.GET)
    public String form(){
        return "cursos/formCurso";
    }

    @RequestMapping(value = "/cadastrarCurso", method = RequestMethod.POST)
    public String form(Curso cursos){
        cursoRepository.save(cursos);
        return "redirect:/cadastrarCurso";
    }

    @RequestMapping("/cursos")
    public ModelAndView listaCursos(){
        ModelAndView mvCurso = new ModelAndView("indexCurso");
        Iterable<Curso> curso = cursoRepository.findAll();
        mvCurso.addObject("cursos", curso);
        return mvCurso;
    }

}
