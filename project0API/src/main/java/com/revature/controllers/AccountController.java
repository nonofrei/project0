package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.models.Account;
import com.revature.services.AccountService;
import io.javalin.http.Handler;

import java.util.ArrayList;

public class AccountController {

    AccountService as = new AccountService();

    public Handler getAllAccountsByUserIdHandler = (ctx) -> {
        if(AuthController.ses != null) {
            int user_id = Integer.parseInt(ctx.pathParam("user_id"));
            ArrayList<Account> accounts = as.getAllAccountsByUserId(user_id);
            Gson gson = new Gson();
            String JSONAccounts = gson.toJson(accounts);
            if (!accounts.isEmpty()) {
                ctx.status(200);
                ctx.result(JSONAccounts);
            } else {
                ctx.status(404);
                ctx.result("No Account Found");
            }
        } else {
            ctx.status(401);
            ctx.result("You must login to see accounts!");
        }
    };


    public Handler deleteAccountByAccountId = (ctx) -> {
        if(AuthController.ses != null) {
            int account_id = Integer.parseInt(ctx.pathParam("account_id"));
            if (as.delete_account(account_id) == null) {
                ctx.status(200);
                ctx.result("DELETED ACCOUNT: " + account_id);
            } else {
                ctx.status(406);
                ctx.result("Account was not deleted :(");
            }
        } else {
            ctx.status(401);
            ctx.result("You must login to delete account!");
        }
    };

    public Handler insertAccount = (ctx) -> {
        if(AuthController.ses != null) {
            String body = ctx.body();
            Gson gson = new Gson();
            Account newAccount = gson.fromJson(body, Account.class);

            try {
                Account returnedAcc = as.insert_new_account(newAccount);
                String JSONAccount = gson.toJson(returnedAcc);
                ctx.status(201);
                ctx.result(JSONAccount);
            } catch (IllegalArgumentException e) {
                ctx.status(406);
                ctx.result(e.getMessage());
            }
        } else {
        ctx.status(401);
        ctx.result("You must login to insert account!");
        }
    };

    public Handler getAccountBalanceByAccountIdHandler = (ctx) -> {
        if(AuthController.ses != null) {
            int account_id = Integer.parseInt(ctx.pathParam("account_id"));
            int balance = as.getAccountBalanceByAccountId(account_id);
            Gson gson = new Gson();
            String JSONBalance = gson.toJson(balance);
            if (balance != -999999) {
                ctx.status(200);
                ctx.result(JSONBalance);
            } else {
                ctx.status(404);
                ctx.result("No Account Found");
            }
        } else {
            ctx.status(401);
            ctx.result("You must login to get account balance!");
        }
    };

    public Handler depositByAccountIdHandler = (ctx) -> {
        if(AuthController.ses != null) {
            int account_id = Integer.parseInt(ctx.pathParam("account_id"));
            int amount = Integer.parseInt(ctx.body());
            try {
                int newBalance = as.depositByAccountId(account_id, amount);
                ctx.status(200);
                ctx.result("New Account Balance: " + newBalance);
            } catch (IllegalArgumentException e) {
                ctx.status(406);
                ctx.result(e.getMessage());
            }
        } else {
            ctx.status(401);
            ctx.result("You must login to make a deposit!");
        }
    };

    public Handler withdrawByAccountIdHandler = (ctx) -> {
        if(AuthController.ses != null) {
            int account_id = Integer.parseInt(ctx.pathParam("account_id"));
            int amount = Integer.parseInt(ctx.body());
            try {
                int newBalance = as.withdrawByAccountId(account_id, amount);
                ctx.status(200);
                ctx.result("New Account Balance: " + newBalance);
            } catch (IllegalArgumentException e) {
                ctx.status(406);
                ctx.result(e.getMessage());
            }
        } else {
            ctx.status(401);
            ctx.result("You must login to make a withdraw!");
        }
    };

    public Handler updateAccountTitleByAccountIdHandler = (ctx) -> {
        if(AuthController.ses != null) {
            int account_id = Integer.parseInt(ctx.pathParam("account_id"));
            String title = ctx.body();
            try {
                as.updateAccountTitleByAccountId(account_id, title);
                ctx.status(200);
                ctx.result("New Account Title: " + title);
            } catch (IllegalArgumentException e) {
                ctx.status(406);
                ctx.result(e.getMessage());
            }
        } else {
            ctx.status(401);
            ctx.result("You must login to update account title!");
        }
    };
}
