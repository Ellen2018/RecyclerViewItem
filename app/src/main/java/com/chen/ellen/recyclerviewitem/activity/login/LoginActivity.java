package com.chen.ellen.recyclerviewitem.activity.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.chen.ellen.basemvp.view.BaseActivity;
import com.chen.ellen.recyclerviewitem.R;
import com.chen.ellen.recyclerviewitem.activity.login.LoginAgreement.AgreementView;

public class LoginActivity extends BaseActivity<LoginAgreement.AgreementPresenter> implements AgreementView{

    private  Button button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        button = findViewById(R.id.bt1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login("ellen","1314");
            }
        });

        //MVP的初始化
        p = new LoginPresenter();
        p.m = new LoginModel();
        p.v = this;

    }

    @Override
    public void login(String account, String password) {
        showLogining();
        p.loginValidate(account,password);

    }

    @Override
    public void showLogining() {

        button.setText("登录中...");

    }

    @Override
    public void loginFailed() {

        button.setText("登录失败！");

    }

    @Override
    public void loginSuccess() {
        button.setText("登录成功！");
    }

    @Override
    public void register() {
        //注册账号
    }

    @Override
    public void forgetPassword() {
        //忘记密码

    }
}
