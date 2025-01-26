package service;

import dao.UserDAO;
import models.User;

import java.sql.SQLException;

public class UserService {
    public static Integer saveUser(User user){
        try {
            if(UserDAO.isUserExits(user.getEmail())) {
                return 0;
            } else {
                return UserDAO.saveUser(user);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
