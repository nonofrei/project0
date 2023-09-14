package com.revature.services;

import com.revature.daos.AccountDAO;
import com.revature.models.Account;

import java.util.ArrayList;

public class AccountService {

    AccountDAO aDAO = new AccountDAO();

    public ArrayList<Account> getAllAccountsByUserId(int user_id){

        return aDAO.getAllAccountsByUserId(user_id);

    }

    public int getAccountBalanceByAccountId(int account_id){

        return aDAO.getAccountBalanceByAccountId(account_id);

    }
}
