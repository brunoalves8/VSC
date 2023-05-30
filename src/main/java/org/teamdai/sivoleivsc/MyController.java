package org.teamdai.sivoleivsc;

import BackEnd.*;
import BackEnd.SaveEvent;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import BackEnd.Form;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class MyController {

    Collection<Appearances> playersTeam1 = new ArrayList<>();
    Collection<Appearances> playersTeam2 = new ArrayList<>();
    Collection<String> teams = new ArrayList<>();
    Iterable<Integer> shirtNumTeam1;
    Iterable<Integer> shirtNumTeam2;
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
            model.addAttribute("allUsers", RemoveAndListUser.listAllUsers());
            return "RemoveUser";
        }
        return "Login";
    }
    @PostMapping("/removeUser")
    public String removeUser(@RequestParam String username, RedirectAttributes redirectAttributes) {
        boolean wasSuccessful = RemoveAndListUser.removeUser(username);

        if (wasSuccessful) {
            redirectAttributes.addFlashAttribute("successMessage", "Utilizador removido com sucesso.");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Ocorreu um erro ao tentar remover o utilizador.");
        }

        return "redirect:/removeUser";
    }


    @GetMapping("/userSettings")
    public String showUserSettings(Model model, HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user instanceof Player) {
            model.addAttribute("player", new Player());
            return "UserSettings";
        }else if(user instanceof Coach) {
            model.addAttribute("coach", new Coach());
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

            // Get the updated player
            Player updatedPlayer = UserSettings.getPlayerByUsername(player.getUsername());

            // Add the updated player to the model
            model.addAttribute("player", updatedPlayer);

            return "UserSettings";
        } else {
            model.addAttribute("error", "Utilizador não existe!");
        }
        return "UserSettings";
    }

    @GetMapping("/userSettingsCoach")
    public String showUserSettingsCoach(Model model, HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user instanceof Coach) {
            model.addAttribute("coach", new Coach());
            return "CoachSettings";
        }
        return "Login";
    }

    @PostMapping("/userSettingsCoach")
    public String processUserSettingsForm(@ModelAttribute("coach") Coach coach, Model model) {
        boolean userAlreadyExists = UserSettings.verifyIfPlayerExists(coach.getUsername());
        return "CoachSettings";
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
        return "redirect:/criarQuestionario";
    }


    @GetMapping("/calendar")
    public String showCalendar(Model model){
        model.addAttribute("player", new Player());
        return "Calendar";
    }


    @GetMapping("/calendarPlayer")
    public String showCalendarPlayer(Model model){
        model.addAttribute("player", new Player());
        return "CalendarPlayer";
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

    @GetMapping("/coachQuestionnairies")
    public String showCoachFormulariosPage(Model model) {
        List<Form> forms = FormsDAO.getAllForms();
        model.addAttribute("forms", forms);
        return "QuestionnairiesListCoach";
    }
    @PostMapping("/coachQuestionnairies")
    public String removeFormLink(@RequestParam String link, RedirectAttributes redirectAttributes) {
        boolean isRemoved = FormsDAO.deleteFormByLink(link);
        if(!isRemoved){
            redirectAttributes.addFlashAttribute("error", "Erro ao tentar eliminar formulário: "+link);
        }
        return "redirect:/coachQuestionnairies";
    }
    @GetMapping("/playerQuestionnairies")
    public String showPlayerFormulariosPage(Model model) {
        List<Form> forms = FormsDAO.getAllForms();
        model.addAttribute("forms", forms);
        return "QuestionnairiesListPlayer";
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
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("A Equipa 1 introduzida não se encontra no sistema");
        }

        if (team2exist) {

        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("A Equipa 2 introduzida não se encontra no sistema");
        }

        playersTeam1 = info.getPlayersTeam1();
        playersTeam2 = info.getPlayersTeam2();
        teams.add(info.getTeam1());
        teams.add(info.getTeam2());
        shirtNumTeam1 = RegisterGame.getShirtNumbersTeam1(info.getPlayersTeam1());
        shirtNumTeam2 = RegisterGame.getShirtNumbersTeam2(info.getPlayersTeam2());

        RegisterGame.registerGame(info.getTeam1(),info.getTeam2(),info.getPlayersTeam1(),info.getPlayersTeam2());

        return ResponseEntity.ok("Informações guardadas com sucesso");
    }


    @GetMapping("/registerCodes")
    public String registerCodes(Model model){
        model.addAttribute("info", new RegisterGame());
        return "RegisterCodes";
    }

    @GetMapping("/playersTeam1")
    @ResponseBody
    public Iterable<Appearances> getPlayersTeam1() {
        Iterable<Appearances> players1 = playersTeam1;
        return players1;
    }

    @GetMapping("/playersTeam2")
    @ResponseBody
    public Iterable<Appearances> getPlayersTeam2() {
        Iterable<Appearances> players2 = playersTeam2;
        return players2;
    }

    @GetMapping("/teams")
    @ResponseBody
    public Iterable<String> getTeams() {
        Iterable<String> teams1and2 = teams;
        return teams1and2;
    }

    @GetMapping("/shirtNumbersTeam1")
    @ResponseBody
    public Iterable<Integer> getShirtNumbersTeam1() {
        Iterable<Integer> shirtNumbersTeam1 = shirtNumTeam1;
        return shirtNumbersTeam1;
    }

    @GetMapping("/shirtNumbersTeam2")
    @ResponseBody
    public Iterable<Integer> getShirtNumbersTeam2() {
        Iterable<Integer> shirtNumbersTeam2 = shirtNumTeam2;
        return shirtNumbersTeam2;
    }
    @GetMapping("/coachGamesSubMenu")
    public String showGames(Model model){
        return "CoachGamesSubMenu";
    }

    @GetMapping("/profile")
    public ModelAndView profile(HttpSession session) {
        ModelAndView mav = new ModelAndView("Profile");
        User user = (User) session.getAttribute("user");
        if (user == null) {
            mav.setViewName("redirect:/login");
        } else {
            if (user instanceof Player) {
                Player player = UserSettings.getPlayerByUsername(user.getUsername());
                session.setAttribute("user", player);
                mav.addObject("user", player);
            } else if (user instanceof Coach) {
                Coach coach = UserSettings.getCoachByUsername(user.getUsername());
                session.setAttribute("user", coach);
                mav.addObject("user", coach);
            }
        }
        return mav;
    }

    @GetMapping("/profile2")
    public ModelAndView profile2(@RequestParam("usernamePlayer") String username, HttpSession session) {
        System.out.println("Username: " + username); // Isto irá imprimir o valor de username no console
        ModelAndView mav = new ModelAndView("ProfileForUserNotLog");

        Player player = UserSettings.getPlayerByUsername(username);
        session.setAttribute("profileViewUser", player);
        mav.addObject("user", player);

        return mav;
    }




    @PostMapping("/profile")
    public String editProfile(@ModelAttribute Player player, HttpSession session) {
        // Here you can add your logic to update the user details.
        boolean isUpdated = UserSettings.updateUser(player); // Update user in your database
        if (isUpdated) {
            // Once updated, replace the user object in the session.
            Player updatedPlayer = UserSettings.getPlayerByUsername(player.getUsername());
            session.setAttribute("user", updatedPlayer);
        }
        return "redirect:/profile";
    }

    //Pedir Boleia
    @GetMapping("/askForRide")
    public String showAskForRide(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");


        return "AskForRide";
    }

    @PostMapping("/insertDataOfLocation")
    public String showinsertDataOfLocation(HttpSession session,@RequestParam("eventName") String eventName, @RequestParam("eventId") int eventId, @RequestParam("pickupLocation") String pickupLocation) {
        User user = (User) session.getAttribute("user");
        RideRequest req = new RideRequest();
        boolean success = req.insertDataOfRequest(eventId, user.getUsername(), pickupLocation,eventName);
        return success ? "RidesSubMenuPlayer" : "askForRide";
    }

    @GetMapping("/offerRide")
    public String doOfferRide(HttpSession session, @RequestParam("requestID") int requestID) {
        User user = (User) session.getAttribute("user");
        RideRequest req = new RideRequest();
        req.acceptRideRequest(requestID, user.getUsername());
        return "RidesSubMenuPlayer";
    }




    //Menu das boleias
    @GetMapping("/ridesSubMenu")
    public String showRidesSubMenuPlayer(Model model) {
        return "RidesSubMenuPlayer";
    }

    //Aba que aparece para introduzir a localização após pedir boleia um evento
    @GetMapping("/pickUpSpot")
    public String showPickUpSpot(Model model) {
        return "PickUpSpot";
    }

    @GetMapping("/showOfferRide")
    public String showOfferRide(Model model) {
        return "OfferRide";
    }

    @GetMapping("/statusRides")
    public String showStatusRides(Model model, HttpSession session ) {
        String username = (String) session.getAttribute("username");
        RideRequest rideRequest = new RideRequest();
        List<RideRequest> requests = rideRequest.findUsernameRideRequest(username);
        model.addAttribute("requests", requests);
        return "StatusRides";
    }

    @GetMapping("/listPlayers")
    public String showListOfPlayers(Model model) {
        return "ListPlayers";
    }
}

