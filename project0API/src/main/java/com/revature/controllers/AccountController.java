package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.models.Account;
import com.revature.services.AccountService;
import io.javalin.http.Handler;

import java.util.ArrayList;

public class AccountController {

    AccountService as = new AccountService();

    public Handler getAllAccountsByUserIdHandler = (ctx) -> {

        int user_id = Integer.parseInt(ctx.pathParam("user_id"));

        ArrayList<Account> accounts = as.getAllAccountsByUserId(user_id);

        Gson gson = new Gson();

        String JSONAccounts = gson.toJson(accounts);

        if(!accounts.isEmpty()){
            ctx.status(200);
            ctx.result(JSONAccounts);
        } else{
            ctx.status(404);
            ctx.result("No Account Found");
        }

    };

    public Handler getAccountBalanceByAccountIdHandler = (ctx) -> {

        int account_id = Integer.parseInt(ctx.pathParam("account_id"));

        int balance = as.getAccountBalanceByAccountId(account_id);

        Gson gson = new Gson();

        String JSONBalance = gson.toJson(balance);

        if(balance != -999999){
            ctx.status(200);
            ctx.result(JSONBalance);
        } else{
            ctx.status(404);
            ctx.result("No Account Found");
        }

    };

}
