package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.models.LoginDTO;
import com.revature.models.User;
import com.revature.services.AuthService;
import io.javalin.http.Handler;
import jakarta.servlet.http.HttpSession;

public class AuthController {
    AuthService authService = new AuthService();
    public static HttpSession ses;

    public Handler loginHandler = (ctx) -> {
        String body = ctx.body();
        Gson gson = new Gson();
        LoginDTO lDTO = gson.fromJson(body, LoginDTO.class);
        User loggedInUser = authService.login(lDTO);
        if(loggedInUser != null){
            ses = ctx.req().getSession();
            ses.setAttribute("user_first_name", loggedInUser.getUser_first_name());
            ses.setAttribute("user_last_name", loggedInUser.getUser_last_name());
            ctx.status(200);
            ctx.result("Welcome, " + ses.getAttribute("user_first_name") + " " + ses.getAttribute("user_last_name"));
        } else {
            ctx.status(401);
            ctx.result("INVALID CREDENTIALS!");
        }

    };
}
