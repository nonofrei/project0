package com.revature.daos;

import com.revature.models.Account;
import com.revature.utils.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;

public class AccountDAO {

    public ArrayList<Account> getAllAccountsByUserId(int user_id){

        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "SELECT * FROM accounts WHERE user_id_fk = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, user_id);

            ResultSet rs = ps.executeQuery();

            ArrayList<Account> accounts = new ArrayList<>();

            while(rs.next()){

                Account a = new Account(
                        rs.getInt("account_id"),
                        rs.getString("account_title"),
                        rs.getInt("account_balance"),
                        rs.getInt("user_id_fk")
                );

                accounts.add(a);

            }

            return accounts;

        } catch(SQLException e){
            System.out.println("GET ACCOUNT FAILED");
            e.printStackTrace();
        }

        return null;

    }

    public Account deleteAccountByUserId(int account_id){

        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "DELETE FROM accounts WHERE account_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, account_id);

            ps.executeUpdate();

        } catch(SQLException e){
            System.out.println("DELETE ACCOUNT FAILED");
            e.printStackTrace();
        }

        return null;

    }

}