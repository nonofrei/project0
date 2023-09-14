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

    public Account deleteAccountByAccountId(int account_id){
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
  
    public int getAccountBalanceByAccountId(int account_id){
        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT account_balance FROM accounts WHERE account_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, account_id);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch(SQLException e){
            System.out.println("GET ACCOUNT FAILED");
            e.printStackTrace();
        }
        return -999999;
    }

    public Account insertAccount(Account account){
        try(Connection conn = ConnectionUtil.getConnection()) {
            String sql = "INSERT INTO accounts (account_title, account_balance, user_id_fk) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, account.getAccount_title());
            ps.setInt(2, account.getAccount_balance());
            ps.setInt(3, account.getUser_id_fk());
            ps.executeUpdate();
            return account;
        } catch(SQLException e) {
            System.out.println("INSERT EMPLOYEE FAILED");
            e.printStackTrace();
        }
        return null;
    }

}