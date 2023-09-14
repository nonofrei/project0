package com.revature;

import com.revature.controllers.AccountController;
import com.revature.controllers.UserController;
import com.revature.utils.ConnectionUtil;
import io.javalin.Javalin;

import java.sql.Connection;
import java.sql.SQLException;

public class Driver {
    public static void main(String[] args) {
        try (Connection conn = ConnectionUtil.getConnection()) {
            System.out.println("Connection Achieved!");
        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }

        Javalin app = Javalin.create().start(8080);

        AccountController ac = new AccountController();
        UserController userController = new UserController();

        app.get("/user/{user_id}", userController.getUsersByIdHandler);
        app.get("/users", userController.getAllUsersHandler);
        app.get("/accounts/{user_id}", ac.getAllAccountsByUserIdHandler);
        app.get("/balance/{account_id}", ac.getAccountBalanceByAccountIdHandler);
        app.patch("/account/{account_id}/deposit", ac.depositByAccountIdHandler);
        app.patch("/account/{account_id}/withdraw", ac.withdrawByAccountIdHandler);
        app.patch("/account/{account_id}", ac.updateAccountTitleByAccountIdHandler);
        app.post("/user", userController.insertUserHandler);
        app.post("/accounts", ac.insertAccount);
      
        app.patch("/user/{user_id}", userController.updateUserNameByUserIdHandler);
      
        app.delete("/accounts/{account_id}", ac.deleteAccountByAccountId);
    }
}
