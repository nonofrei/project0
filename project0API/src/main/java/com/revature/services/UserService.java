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

    public User updateUserNameByUserId(int user_id, String user_first_name, String user_last_name){
        return userDAO.updateUserNameByUserId(user_id, user_first_name, user_last_name);
    }

}