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

}
