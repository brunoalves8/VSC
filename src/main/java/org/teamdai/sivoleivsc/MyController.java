package org.teamdai.sivoleivsc;

import BackEnd.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {
    @GetMapping("/home")
    public String Home() {
        return "Home"; // este é o nome do arquivo JSP que contém o código HTML
    }

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


    @GetMapping("/playerRegistration")
    public String showPlayerRegistration(Model model){
        model.addAttribute("player", new Player());
        return "PlayerRegistration";
    }

    @PostMapping("/playerRegistration")
    public String processRegistrationForm(@ModelAttribute("player") Player player, Model model) {
        boolean userAlreadyExists = RegisterPlayer.verifyIfUserExists(player.getUsername());

        if (userAlreadyExists) {
            model.addAttribute("error", "Username already in use");
            return "PlayerRegistration";
        } else {
            RegisterPlayer.registerPlayer(player.getName(), player.getUsername(), player.getEmail(),
                    player.getPhoneNumber(), player.getPassword());
            return "redirect:/home";
        }
    }

    @GetMapping("/coachRegistration")
    public String showCoachRegistration(Model model){
        model.addAttribute("player", new Player());
        return "CoachRegistration";
    }

    @PostMapping("/coachRegistration")
    public String processRegistrationForm(@ModelAttribute("coach") Coach coach, @RequestParam String type, Model model) {
        boolean userAlreadyExists = RegisterPlayer.verifyIfUserExists(coach.getUsername());

        if (userAlreadyExists) {
            model.addAttribute("error", "Username already in use");
            return "CoachRegistration";
        } else {
            coach.setType(type);

            RegisterCoach.registerCoach(coach.getName(), coach.getUsername(), coach.getEmail(),
                    coach.getPhoneNumber(), coach.getPassword(), coach.getType());
            return "redirect:/home";
        }
    }





}
