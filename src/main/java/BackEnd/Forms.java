/*
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class Forms {
    private static final String FORM_ID = "your_form_id";
            // your form id = https://docs.google.com/forms/d/your_form_id/edit

    private static final String ENTRY_ID_USERNAME = "your_entry_id_username";
            // entry id username vai-se buscar à "pergunta" do user do forms

    public static String getCustomFormLink (String username) {
        String formUrlTemplate = "https://docs.google.com/forms/d/e/" + FORM_ID + "/viewform?usp=pp_url&entry." + ENTRY_ID_USERNAME + "={username}";
        return formUrlTemplate.replace("{username}", username);
    }

    // Etapa 2
    String username = getUsername(); // Substitua esta função pela função que retorna o nome de usuário do jogador atual.
    String customFormLink = Forms.getCustomFormLink(username);
    request.setAttribute("customFormLink", customFormLink); // Use o método adequado para passar a variável à sua página HTML, dependendo do seu framework (Servlet, JSP, Thymeleaf, etc.).

}
*/


