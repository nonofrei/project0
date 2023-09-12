package com.revature;

import com.revature.controllers.AccountController;
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

        app.get("/accounts/{user_id}", ac.getAllAccountsByUserIdHandler);

    }
}
