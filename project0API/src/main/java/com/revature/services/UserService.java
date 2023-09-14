package com.revature.services;

import com.revature.daos.UserDAO;
import com.revature.models.User;

import java.util.ArrayList;

public class UserService {

    UserDAO userDAO = new UserDAO();

    public User insertUser(User user) throws IllegalArgumentException {
        // Check that the first name and last name come in are not NULL
        if (user.getUser_first_name() == null || user.getUser_last_name() == null) {
            throw new IllegalArgumentException("Employee names must not be null!");
        }
        // Check that the first name and last name come in are not EMPTY
        if (user.getUser_first_name().isEmpty() || user.getUser_last_name().isEmpty()) {
            throw new IllegalArgumentException("Employee names must not be empty!");
        }
        return userDAO.insertUser(user);
    }

    public ArrayList<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public User getUserById(int user_id) {
        return userDAO.getUserById(user_id);
    }


}
