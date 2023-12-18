package br.com.desafio.ceuma.faculdade.controller;

import br.com.desafio.ceuma.faculdade.model.Aluno;
import br.com.desafio.ceuma.faculdade.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AlunoFrontController {

    @Autowired
    private AlunoRepository alunoRepository;

    @RequestMapping(value = "/cadastrarAluno", method = RequestMethod.GET)
    public String form(){
        return "aluno/formAluno";
    }

    @RequestMapping(value = "/cadastrarAluno", method = RequestMethod.POST)
    public String form(Aluno alunos){
        alunoRepository.save(alunos);
        return "redirect:/cadastrarAluno";
    }

    @RequestMapping("/alunos")
    public ModelAndView listaAlunos(){
        ModelAndView mv = new ModelAndView("index");
        Iterable<Aluno> aluno = alunoRepository.findAll();
        mv.addObject("alunos", aluno);
        return mv;
    }



}
