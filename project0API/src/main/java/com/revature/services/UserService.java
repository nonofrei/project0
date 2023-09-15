package com.revature.services;

import com.revature.daos.UserDAO;
import com.revature.models.User;

import java.util.ArrayList;

public class UserService {

    UserDAO userDAO = new UserDAO();

    public User insertUser(User user) throws IllegalArgumentException {
        // Check that the first name and last name come in are not NULL
        if (user.getUser_first_name() == null || user.getUser_last_name() == null) {
            throw new IllegalArgumentException("First and Last name must not be null!");
        }
        // Check that the first name and last name come in are not EMPTY
        if (user.getUser_first_name().isEmpty() || user.getUser_last_name().isEmpty()) {
            throw new IllegalArgumentException("First and Last name must not be empty!");
        }
        if (user.getUser_username() == null || user.getUser_password() == null) {
            throw new IllegalArgumentException("Username and password must not be null!");
        }
        if (user.getUser_username().isEmpty() || user.getUser_password().isEmpty()) {
            throw new IllegalArgumentException("Username and password must not be empty!");
        }
        return userDAO.insertUser(user);
    }


    public User updateUserNameByUserId(int user_id, String user_first_name, String user_last_name){
        return userDAO.updateUserNameByUserId(user_id, user_first_name, user_last_name);
    }

    public ArrayList<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public User getUserById(int user_id) {
        return userDAO.getUserById(user_id);
    }
}
