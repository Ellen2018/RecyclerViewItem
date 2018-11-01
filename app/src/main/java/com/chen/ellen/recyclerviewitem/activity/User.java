package com.chen.ellen.recyclerviewitem.activity;

import javax.inject.Inject;

public class User {

    private String account = "";
    private String password = "";

    @Inject
    public User(){
        account = "ellen";
        password = "1314";
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
