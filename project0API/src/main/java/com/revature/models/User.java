package com.revature.models;

public class User {

    private int user_id;
    private String user_first_name;
    private String user_last_name;
    private String user_username;
    private String user_password;

    public User() {
    }

    public User(int user_id, String user_first_name, String user_last_name, String user_username) {
        this.user_id = user_id;
        this.user_first_name = user_first_name;
        this.user_last_name = user_last_name;
        this.user_username = user_username;
    }

    public User(int user_id, String user_first_name, String user_last_name, String user_username, String user_password) {
        this.user_id = user_id;
        this.user_first_name = user_first_name;
        this.user_last_name = user_last_name;
        this.user_username = user_username;
        this.user_password = user_password;
    }

    public User(String user_first_name, String user_last_name) {
        this.user_first_name = user_first_name;
        this.user_last_name = user_last_name;
    }

    public User(int user_id, String user_first_name, String user_last_name) {
        this.user_id = user_id;
        this.user_first_name = user_first_name;
        this.user_last_name = user_last_name;
    }

    public User(String user_first_name, String user_last_name, String user_username, String user_password) {
        this.user_first_name = user_first_name;
        this.user_last_name = user_last_name;
        this.user_username = user_username;
        this.user_password = user_password;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_first_name() {
        return user_first_name;
    }

    public void setUser_first_name(String user_first_name) {
        this.user_first_name = user_first_name;
    }

    public String getUser_last_name() {
        return user_last_name;
    }

    public String getUser_username() {
        return user_username;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_last_name(String user_last_name) {
        this.user_last_name = user_last_name;
    }

    @Override
    public java.lang.String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_first_name='" + user_first_name + '\'' +
                ", user_last_name='" + user_last_name + '\'' +
                '}';
    }
}