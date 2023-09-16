package com.revature.services;

import com.revature.daos.AuthDAO;
import com.revature.models.LoginDTO;
import com.revature.models.User;

public class AuthService {

    AuthDAO authDAO = new AuthDAO();

    public User login(LoginDTO lDTO) {
        User user = authDAO.login(lDTO.getUser_username(),lDTO.getUser_password());
        if(user != null){
            return user;
        }
        return null;
    }

}
