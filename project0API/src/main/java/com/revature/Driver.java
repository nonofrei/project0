package com.revature;

import com.revature.controllers.AccountController;

public class Driver {
    public static void main(String[] args) {

        Javalin app = Javalin.create().start(8080);

        AccountController ac = new AccountController();

        app.get("/accounts/{user_id}", ac.getAllAccountsByUserIdHandler);

    }
}
