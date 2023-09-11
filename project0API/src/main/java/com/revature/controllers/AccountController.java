package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.models.Account;
import com.revature.services.AccountService;
import io.javalin.http.Handler;

import java.util.ArrayList;

public class AccountController {

    AccountService as = new AccountService();

    public Handler getAllAccountsByUserIdHandler = (ctx) -> {

        int user_id = ctx.pathParam("user_id");

        ArrayList<Account> accounts = as.getAllAccountsByUserId(user_id);

        Gson gson = new Gson();

        String JSONAccounts = gson.toJson(accounts);

        if(accounts != null){
            ctx.status(200);
            ctx.result(JSONAccounts);
        } else{
            ctx.status(406);
            ctx.result("Invalid ID");
        }

    }

}
