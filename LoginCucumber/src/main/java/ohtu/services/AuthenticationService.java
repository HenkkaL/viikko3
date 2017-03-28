package ohtu.services;

import ohtu.domain.User;
import java.util.ArrayList;
import java.util.List;
import ohtu.data_access.UserDao;

public class AuthenticationService {

    private UserDao userDao;
    public static final int PASSWORD_LENGTH = 8;
    public static final int USERNAME_LENGTH = 3;

    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean createUser(String username, String password) {
        if (userDao.findByName(username) != null) {
            return false;
        }

        if (invalid(username, password)) {
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    private boolean invalid(String username, String password) {
        if (username.length() < USERNAME_LENGTH)
            return true;
        if (password.length() < PASSWORD_LENGTH)
            return true;
        boolean DigitOrOther = true;
        for (int i = 0; i < password.length(); i++){
            if ((int)password.charAt(i) < 65) 
                DigitOrOther = false;  
            if ((int)password.charAt(i) > 122)
                DigitOrOther = false;  
        }

         return DigitOrOther;
    }
}
