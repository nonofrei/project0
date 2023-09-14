package com.revature.services;

import com.revature.daos.UserDAO;
import com.revature.models.User;

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

}
