package com.revature.models;

public class Account {

    private int account_id;
    private String account_title;
    private int account_balance;
    private int user_id_fk;

    public Account() {
    }

    public Account(int account_id, String account_title, int account_balance, int user_id_fk) {
        this.account_id = account_id;
        this.account_title = account_title;
        this.account_balance = account_balance;
        this.user_id_fk = user_id_fk;
    }

    public Account(String account_title, int account_balance, int user_id_fk) {
        this.account_title = account_title;
        this.account_balance = account_balance;
        this.user_id_fk = user_id_fk;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getAccount_title() {
        return account_title;
    }

    public void setAccount_title(String account_title) {
        this.account_title = account_title;
    }

    public int getAccount_balance() {
        return account_balance;
    }

    public void setAccount_balance(int account_balance) {
        this.account_balance = account_balance;
    }

    public int getUser_id_fk() {
        return user_id_fk;
    }

    public void setUser_id_fk(int user_id_fk) {
        this.user_id_fk = user_id_fk;
    }

    @Override
    public java.lang.String toString() {
        return "Account{" +
                "account_id=" + account_id +
                ", account_title='" + account_title + '\'' +
                ", account_balance=" + account_balance +
                ", user_id_fk=" + user_id_fk +
                '}';
    }


}
