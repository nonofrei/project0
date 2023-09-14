package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.models.User;
import com.revature.services.UserService;
import io.javalin.http.Handler;

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

}
