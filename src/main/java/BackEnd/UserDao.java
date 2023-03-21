package BackEnd;

import org.apache.commons.validator.routines.EmailValidator;

public class UserDao {

    public boolean isValidEmail(String email) {
        // criar um validador de e-mail
        EmailValidator validator = EmailValidator.getInstance();

        return validator.isValid(email);
    }


}