package com.chen.ellen.recyclerviewitem.activity.login;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenter extends LoginAgreement.AgreementPresenter {


    @Override
    public void loginValidate(final String account, final String password) {


        Observable.create(new ObservableOnSubscribe<Boolean>() {
            @Override
            public void subscribe(ObservableEmitter<Boolean> emitter) throws Exception {
                boolean falg = m.remoteModel.validateLogin(account, password);
                emitter.onNext(falg);
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {


                        if (aBoolean) {
                            //登录成功
                            v.loginSuccess();
                            Log.e("11111","在主线程中执行了");
                        } else {
                            //登录失败
                            v.loginFailed();
                        }

                    }
                });


    }

    @Override
    public void loginValidataToken(String token) {

    }
}
