package com.chen.ellen.recyclerviewitem.activity.login;

import com.chen.ellen.basemvp.model.BaseModel;
import com.chen.ellen.basemvp.model.LocalModel;
import com.chen.ellen.basemvp.model.RemoteModel;
import com.chen.ellen.basemvp.presenter.BasePresenter;
import com.chen.ellen.basemvp.view.BaseView;

public class LoginAgreement {

    static class AgreementLocalModle implements LocalModel {



    }

    static class AgreementRemoteModle implements RemoteModel{
        public boolean validateLogin(String account,String password){

            //此处网络登录流程-模拟耗时2s
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(account.equals("ellen")&&password.equals("1314")){
                return  true;
            }else{
                return false;
            }

        }
    }


    //协议化Model层
   public static abstract  class AgreementModel extends BaseModel<AgreementLocalModle,AgreementRemoteModle>{

        public AgreementModel(){
            super();
        }

        @Override
        public void initLocalModel() {

            localModel = new AgreementLocalModle();

        }

        @Override
        public void initRemoteModel() {

            remoteModel = new AgreementRemoteModle();

        }
    }

    //协议化View层
    public static interface AgreementView extends BaseView{

       //登录
       public abstract void login(String account,String password);

       //登录中
        public abstract void showLogining();

        //登录失败
        public abstract void loginFailed();

        //登录成功
        public abstract void loginSuccess();

        //注册
        public abstract void register();

        //忘记密码
        public abstract void forgetPassword();

    }


    //协议化P层
    public static abstract class AgreementPresenter extends BasePresenter<AgreementModel,AgreementView>{

       //验证登录
       public abstract void loginValidate(String account,String password);

       //二次验证登录
        public abstract void loginValidataToken(String token);


    }


}
