package org.teamdai.sivoleivsc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
@Controller
public class MyController {
    @GetMapping("/teste")
    public String teste() {
        return "teste"; // este é o nome do arquivo JSP que contém o código HTML
    }
    @GetMapping("/")
    public String kiko() {
        return "kiko"; // este é o nome do arquivo JSP que contém o código HTML
    }
}
