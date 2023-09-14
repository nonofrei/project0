package com.revature.services;

import com.revature.daos.AccountDAO;
import com.revature.models.Account;

import java.util.ArrayList;

public class AccountService {

    AccountDAO aDAO = new AccountDAO();

    public ArrayList<Account> getAllAccountsByUserId(int user_id){
        return aDAO.getAllAccountsByUserId(user_id);
    }

    public Account delete_account(int account_id) {
        return aDAO.deleteAccountByAccountId(account_id);
    }

    public Account insert_new_account(Account account) throws IllegalArgumentException{
        if (account.getAccount_title() == null) {
            throw new IllegalArgumentException("Account title cannot be null");
        }
        if (account.getAccount_balance() < 0) {
            throw new IllegalArgumentException("Cannot open account with negative balance");
        }
        if (account.getUser_id_fk() < 0) {
            throw new IllegalArgumentException("Must connect account to a user");
        }
        return aDAO.insertAccount(account);
    }

    public int getAccountBalanceByAccountId(int account_id){
        return aDAO.getAccountBalanceByAccountId(account_id);
    }

    public int depositByAccountId(int account_id, int amount) throws IllegalArgumentException{
        int oldBalance = aDAO.getAccountBalanceByAccountId(account_id);
        if(amount < 0){
            throw new IllegalArgumentException("Can't deposit negative amount of money!");
        }
        if(oldBalance == -999999){
            throw new IllegalArgumentException("Account doesn't exist!");
        }
        int newBalance = oldBalance + amount;
        return aDAO.updateAccountBalanceByAccountId(account_id, newBalance);
    }

    public int withdrawByAccountId(int account_id, int amount) throws IllegalArgumentException{
        int oldBalance = aDAO.getAccountBalanceByAccountId(account_id);
        if(amount < 0){
            throw new IllegalArgumentException("Can't withdraw negative amount of money!");
        }
        if(oldBalance == -999999){
            throw new IllegalArgumentException("Account doesn't exist!");
        }
        if(amount > oldBalance){
            throw new IllegalArgumentException("Withdraw amount can't exceed account balance!");
        }
        int newBalance = oldBalance - amount;
        return aDAO.updateAccountBalanceByAccountId(account_id, newBalance);
    }

    public String updateAccountTitleByAccountId(int account_id, String newTitle) throws IllegalArgumentException{
        if(newTitle.isEmpty()){
            throw new IllegalArgumentException("New title can't be empty!");
        }
        return aDAO.updateAccountTitleByAccountId(account_id, newTitle);
    }
}
