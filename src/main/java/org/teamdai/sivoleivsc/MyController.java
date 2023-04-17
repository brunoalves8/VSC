package org.teamdai.sivoleivsc;

import BackEnd.ListOfUsers;
import BackEnd.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.List;

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
    public String processLoginForm(@ModelAttribute("user") User login, Model model) {
        boolean authenticated = AuthenticatePlayer.authenticate(login.getUsername(), login.getPassword());

        if (authenticated) {
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Invalid credentials. Please try again.");
            return "Login";
        }
    }


     /*@PostMapping("/login")
    public String processLoginForm(@ModelAttribute LoginForm form, Model model) {
        String username = login.getUsername();
        String password = login.getPassword();
        boolean authenticated;
        authenticated = AuthenticatePlayer.authenticate(username, password);
        if (authenticated){
            return "redirect:/home";
        } else {
            return "Login";
        }
    }*/

   /* @PostMapping("/login")
    public String submitLoginForm(@ModelAttribute User login){

    }*/


























}
