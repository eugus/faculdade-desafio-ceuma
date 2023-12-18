package br.com.desafio.ceuma.faculdade;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/ola")
    public String index(){
        return "index";
    }
}
