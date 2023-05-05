package org.teamdai.sivoleivsc;

import BackEnd.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;
import BackEnd.Form;


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
            model.addAttribute("error", "Credenciais Inválidas. Tente novamente.");
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
            model.addAttribute("error", "Username já está em uso!");
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
        boolean userAlreadyExists = RegisterCoach.verifyIfUserExists(coach.getUsername());

        if (userAlreadyExists) {
            model.addAttribute("error", "Username já está em uso!");
            return "CoachRegistration";
        } else {
            coach.setType(type);

            RegisterCoach.registerCoach(coach.getName(), coach.getUsername(), coach.getEmail(),
                    coach.getPhoneNumber(), coach.getPassword(), coach.getType());
            return "redirect:/home";
        }
    }


    @GetMapping("/removeUser")
    public String showRemoveUser(Model model){
        model.addAttribute("user", new User());
        return "RemoveUser";
    }

    @PostMapping("/removeUser")
    public String processRemoveUserForm(@ModelAttribute("user") User user, Model model) {
        boolean removed = RemoveUser.removeUser(user.getUsername());
        if (removed) {
            model.addAttribute("success", "Utilizador removido!");
        } else {
            model.addAttribute("error", "Utilizador não existe!");
        }

        return "RemoveUser";
    }

    @GetMapping("/userSettings")
    public String showUserSettings(Model model){
        model.addAttribute("player", new Player());
        return "UserSettings";
    }

    @PostMapping("/userSettings")
    public String processUserSettingsForm(@ModelAttribute("player") Player player, Model model) {
        boolean userAlreadyExists = UserSettings.verifyIfPlayerExists(player.getUsername());

        if (userAlreadyExists) {
            UserSettings.addInfoPlayer(player.getPosition(), player.getHeight(), (int) player.getWeight(), player.getShirtNumber(), player.getBirthDate());
            return "UserSettings";
        } else {

            model.addAttribute("error", "Utilizador não existe!");
        }
     return "UserSettings";
    }
/*
    @PostMapping("/changePassword")
    public String processChangePasswordForm(@ModelAttribute("player") Player player, Model model) {
        boolean userAlreadyExists = UserSettings.verifyIfPlayerExists(player.getUsername());

        if (userAlreadyExists) {
            UserSettings.addInfoPlayer(player.getPosition(), player.getHeight(), (int) player.getWeight(), player.getShirtNumber(), player.getBirthDate());
            return "UserSettings";
        } else {

            model.addAttribute("error", "Utilizador não existe!");
        }
        return "UserSettings";
    }
*/


    @GetMapping("/calendar")
    public String showCalendar(Model model){
        model.addAttribute("player", new Player());
        return "Calendar";
    }

    @PostMapping("/addFormLink")
    public String addFormLink(@RequestParam String link, @RequestParam String name, @RequestParam Date endDate) {
        FormsDAO.insertForm(link, name, endDate.toString());
        return "redirect:/home";
    }

    @PostMapping("/removeFormLink")
    public String removeFormLink(@RequestParam String link) {
        FormsDAO.deleteFormByLink(link);
        return "redirect:/home";
    }

    @GetMapping("/forms")
    public List<Form> getAllForms() {
        List<Form> forms = FormsDAO.getAllForms();
        return forms;
    }

    @GetMapping("/currentforms")
    public List<Form> getCurrentForms() {
        List<Form> forms = FormsDAO.getCurrentForms();
        return forms;
    }

}


