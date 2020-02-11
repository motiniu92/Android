package com.example.loginapplication.model;

public class Users {

    private int login_success;
    private int customer_id;


    public void setLogin_success(int login_success) {
        this.login_success = login_success;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getLogin_success() {
        return login_success;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public Users(int login_success, int customer_id) {
        this.login_success = login_success;
        this.customer_id = customer_id;
    }

    public Users() {
    }
}
