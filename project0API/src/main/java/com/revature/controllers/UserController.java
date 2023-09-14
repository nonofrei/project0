package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.models.User;
import com.revature.services.UserService;
import io.javalin.http.Handler;

import java.util.ArrayList;

public class UserController {

    UserService userService = new UserService();

    public Handler insertUserHandler = (ctx) -> {
        String body = ctx.body();
        Gson gson = new Gson();
        User newUser = gson.fromJson(body, User.class);
        try {
            User returnedUser = userService.insertUser(newUser);
            String JSONUser = gson.toJson(returnedUser);
            ctx.status(201);
            ctx.result(JSONUser);
        } catch (IllegalArgumentException e) {
            ctx.status(406);
            ctx.result(e.getMessage());
        }
    };

    public Handler getAllUsersHandler = (ctx) -> {
        try {
            ArrayList<User> users = userService.getAllUsers();
            Gson gson = new Gson();
            String JSONUsers = gson.toJson(users);
            ctx.status(200);
            ctx.result(JSONUsers);
        } catch (IllegalArgumentException e) {
            ctx.status(406);
            ctx.result(e.getMessage());
        }
    };

    public Handler getUsersByIdHandler = (ctx) -> {
        try {
            int user_id = Integer.parseInt(ctx.pathParam("user_id"));
            User user = userService.getUserById(user_id);
            Gson gson = new Gson();
            String JSONUser = gson.toJson(user);
            ctx.status(200);
            ctx.result(JSONUser);
        } catch (IllegalArgumentException e) {
            ctx.status(406);
            ctx.result(e.getMessage());
        }
    };

}
