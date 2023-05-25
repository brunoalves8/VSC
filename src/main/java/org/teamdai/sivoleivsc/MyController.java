package org.teamdai.sivoleivsc;

import BackEnd.*;
import BackEnd.SaveEvent;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import BackEnd.Form;


@Controller
public class MyController {


    private final HttpSession session;

    public MyController(HttpSession session) {
        this.session = session;
    }


    @GetMapping("/home")
    public String Home() {
        return "Home";
    }

    @GetMapping("/player")
    public String PlayerMenu() {
        User user = (User) session.getAttribute("user");
        if(user instanceof Player) {
            return "PlayerMenu";
        }
        return "Login";
    }

    @GetMapping("/coach")
    public String CoachMenu() {
        User user = (User) session.getAttribute("user");
        if(user instanceof Coach) {
            return "CoachMenu";
        }
        return "Login";
    }

    @GetMapping("/director")
    public String DirectorMenu() {
        User user = (User) session.getAttribute("user");
        if(user instanceof Director) {
            return "DirectorMenu";
        }
        return "Login";
    }

    @GetMapping("/coachQuestionnaries")
    public String CoachSubMenu() {
        User user = (User) session.getAttribute("user");
        if(user instanceof Coach) {
            return "CoachSubMenuQuestionnaires";
        }
        return "Login";
    }

    @GetMapping("/directorRegister")
    public String DirectorSubMenu() {
        User user = (User) session.getAttribute("user");
        if(user instanceof Director) {
            return "DirectorSubMenu";
        }
        return "Login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("login", new User());
        return "Login";
    }
    @PostMapping("/login")
    public String processLoginForm(@ModelAttribute("user") User login, Model model) {
        int authenticated = AuthenticateUser.authenticate(login.getUsername(), login.getPassword());
        if (authenticated == 1) {
            Player user = new Player(login.getUsername());
            session.setAttribute("user", user);
            return "redirect:/player";
        } else if (authenticated == 2){
            Coach user = new Coach(login.getUsername());
            session.setAttribute("user", user);
            return "redirect:/coach";
        } else if (authenticated == 3){
            Director user = new Director(login.getUsername());
            session.setAttribute("user", user);
            return "redirect:/director";
        } else {
            model.addAttribute("error", "Credenciais Inválidas. Tente novamente.");
            return "Login";
        }
    }


    @GetMapping("/playerRegistration")
    public String showPlayerRegistration(Model model, HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user instanceof Director) {
            model.addAttribute("player", new Player());
            return "PlayerRegistration";
        }
        return "Login";
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
            return "redirect:/director";
        }
    }

    @GetMapping("/coachRegistration")
    public String showCoachRegistration(Model model, HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user instanceof Director) {
            model.addAttribute("coach", new Coach());
            return "CoachRegistration";
        }
        return "Login";
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
            return "redirect:/director";
        }
    }


    @GetMapping("/removeUser")
    public String showRemoveUser(Model model, HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user instanceof Director) {
            model.addAttribute("user", new User());
            return "RemoveUser";
        }
        return "Login";
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
    public String showUserSettings(Model model, HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user instanceof Player) {
            model.addAttribute("player", new Player());
            return "UserSettings";
        }
        return "Login";
    }

    @PostMapping("/userSettings")
    public String processUserSettingsForm(@ModelAttribute("player") Player player, Model model) {
        boolean userAlreadyExists = UserSettings.verifyIfPlayerExists(player.getUsername());

        if (userAlreadyExists) {
            UserSettings.addInfoPlayer(player.getPosition(), player.getHeight(), (int) player.getWeight(),
                    player.getShirtNumber(), player.getBirthDate(), player.getUsername());
            return "UserSettings";
        } else {

            model.addAttribute("error", "Utilizador não existe!");
        }
     return "UserSettings";
    }

    @PostMapping("/changePassword")
    public String processChangePasswordForm(@ModelAttribute("passwordForm") PasswordForm passwordForm, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        String username = user.getUsername();
        String currentPassword = passwordForm.getCurrentPassword();
        String newPassword = passwordForm.getNewPassword();
        String confirmPassword = passwordForm.getConfirmPassword();

        // Adicione aqui a lógica para verificar se a senha atual corresponde à senha armazenada no banco de dados
       if(UserSettings.verifyCurrentPassword(username, currentPassword) == false){
           model.addAttribute("error", "Palavra-passe introduzida não corresponde à atual!");
       }

       if(UserSettings.verifyIfNewPasswordEqualConfirmPassword(newPassword,confirmPassword)){
           UserSettings.changePassword(username,newPassword);
           return "redirect:/userSettings";
       }
       else
       {
           model.addAttribute("error", "Palavras-passes não coincidem!");
       }

        return "redirect:/userSettings";
    }
    @GetMapping("/criarQuestionario")
    public String showCreateQuestionnairies(Model model) {
        model.addAttribute("form", new Form());
        return "CreateQuestionnairies";
    }

    @PostMapping("/criarQuestionario")
    public String addFormLink(@ModelAttribute("form") Form form, Model model) {
        FormsDAO.insertForm(form.getLink(), form.getName(), form.getEndDate());
        return "redirect:/home";
    }


    @GetMapping("/calendar")
    public String showCalendar(Model model){
        model.addAttribute("player", new Player());
        return "Calendar";
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

    @GetMapping("/formularios")
    public String showFormulariosPage(Model model) {
        List<Form> forms = FormsDAO.getAllForms();
        model.addAttribute("forms", forms);
        return "QuestionnairiesList";
    }


    @PostMapping("/adicionar-evento")
    public ResponseEntity<String> adicionarEvento(@RequestBody Event evento) {

        boolean insertedEvent = SaveEvent.insertEvent(evento);

        if (insertedEvent) {
            return ResponseEntity.ok("Evento adicionado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao adicionar evento");
        }
    }

    @PostMapping("/remover-evento")
    public ResponseEntity<String> removerEvento(@RequestBody Event evento) {

        boolean removedEvent = RemoveEvent.removeEvent(evento);

        if (removedEvent) {
            return ResponseEntity.ok("Evento removido com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao remover evento");
        }
    }

    @GetMapping("/eventos")
    @ResponseBody
    public Iterable<Event> getEvents() {
        Iterable<Event> events = SaveEvent.getAllEvents();
        return events;
    }

    @GetMapping("/availableRidesForEvent/{eventID}")
    public List<Ride> getAvailableRidesForEvent(@PathVariable String eventID) {
        List<Ride> rides = RidesDAO.getAvailableRidesForEvent(eventID);
        return rides;
    }

    @PostMapping("/insertRide")
    public boolean insertRide(@RequestBody Ride ride) {
        return RidesDAO.insertRide(ride.getRideDate(), ride.getEventID(), ride.getAvailableSeats(), ride.getUsername(), ride.isRideStatus());
    }

    @PostMapping("/takeRide/{rideID}/{username}")
    public boolean takeRide(@PathVariable int rideID, @PathVariable String username) {
        return RidesDAO.takeRide(rideID, username);
    }

    @GetMapping("/infoGameVideo")
    public String showInfoGameVideo(Model model){
        model.addAttribute("info", new RegisterGame());
        return "CreateTeams&Players";
    }

    @PostMapping("/adicionarInfoGameVideo")
    public ResponseEntity<?> adicionarInfoGameVideo(@RequestBody RegisterGame info, Model model) {
        boolean team1exist = RegisterGame.verifyIfTeamExists(info.getTeam1());
        boolean team2exist = RegisterGame.verifyIfTeamExists(info.getTeam2());

        if (team1exist) {

        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("A Equipa digitada não se encontra no sistema");
        }

        if (team2exist) {

        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("A Equipa digitada não se encontra no sistema");
        }

        RegisterGame.registerGame(info.getTeam1(),info.getTeam2(),info.getPlayersTeam1(),info.getPlayersTeam2());

        return ResponseEntity.ok("Informações guardadas com sucesso");
    }

    @GetMapping("/registerCodes")
    public String showPageRegisterCode(Model model) {
        model.addAttribute("codes", new RegisterGame());
        return "RegisterCodes";
    }
}


