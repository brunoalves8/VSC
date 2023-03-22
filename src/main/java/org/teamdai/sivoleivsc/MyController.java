package org.teamdai.sivoleivsc;

import BackEnd.ListOfUsers;
import BackEnd.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class MyController {
    @GetMapping("/home")
    public String Home() {
        return "Home"; // este é o nome do arquivo JSP que contém o código HTML
    }
    /*@GetMapping("/")
    public String kiko() {
        return "kiko"; // este é o nome do arquivo JSP que contém o código HTML
    }*/
   /* @GetMapping("/")
    public String Login() {
        return "Login"; // este é o nome do arquivo JSP que contém o código HTML
    }*/
    /*@PostMapping("/login")
    public String login(@RequestParam("Username") String username,
                        @RequestParam("Password") String password,
                        Model model) {

        // Verifica as credenciais
        if (username.equals("admin") && password.equals("admin")) {
            // Login bem sucedido, redireciona para a página principal
            return "redirect:/home";
        } else {
            // Login falhou, retorna para a página de login com uma mensagem de erro
            model.addAttribute("error", "Credenciais inválidas");
            return "Login";
        }
    }*/
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("login", new User());
        return "Login";
    }

    @PostMapping("/login")
    public String submitLoginForm(@ModelAttribute User login) {
        if (login.getUsername().equals("admin") && login.getPassword().equals("admin")) {
            return "redirect:/home";
            //Para já deixar estar assim
        } else {
            return "Login";
        }
    }

}
