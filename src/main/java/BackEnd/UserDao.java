package BackEnd;

import org.apache.commons.validator.routines.EmailValidator;

public class UserDao {
    // criar um validador de e-mail
    public boolean isValidEmail(String email) {

        EmailValidator validator = EmailValidator.getInstance();
        return validator.isValid(email);
    }

}