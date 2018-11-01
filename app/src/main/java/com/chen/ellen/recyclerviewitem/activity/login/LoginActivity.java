package com.chen.ellen.recyclerviewitem.activity.login;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.chen.ellen.basemvp.view.BaseActivity;
import com.chen.ellen.recyclerviewitem.R;
import com.chen.ellen.recyclerviewitem.activity.User;
import com.chen.ellen.recyclerviewitem.activity.login.LoginAgreement.AgreementView;
import com.squareup.picasso.Picasso;

import java.io.File;

import javax.inject.Inject;

public class LoginActivity extends BaseActivity<LoginAgreement.AgreementPresenter> implements AgreementView{

    private  Button button;

    private ImageView imageView;

    private final int REQUEST_CODE_TAKE_PICTURE = 0;

    private final int PERSSION_CAEMR = 1;

    File file ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        button = findViewById(R.id.bt1);
        imageView = findViewById(R.id.iv1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //启动本地相机拍照并且显示出来

                int hasWriteStoragePermission = ContextCompat.checkSelfPermission(getApplication(), Manifest.permission.CAMERA);
                if (hasWriteStoragePermission == PackageManager.PERMISSION_GRANTED) {
                    //拥有权限，则执行操作
                    Intent openCameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    file = new File(getExternalCacheDir(), System.currentTimeMillis()+".jpg");

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                        openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                                FileProvider.getUriForFile(LoginActivity.this,"com.chen.ellen.recyclerviewitem.fileprovider", file));
                    }else {
                        openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                    }

                    startActivityForResult(openCameraIntent, REQUEST_CODE_TAKE_PICTURE);
                }else{
                    //没有权限，向用户请求权限
                    ActivityCompat.requestPermissions(LoginActivity.this, new String[]{Manifest.permission.CAMERA},PERSSION_CAEMR );
                }



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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){

            case REQUEST_CODE_TAKE_PICTURE:

                if ( resultCode == RESULT_OK) {

//                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
//                        Uri uri = FileProvider.getUriForFile(this, "包名.fileprovider", file);
//                    }else {
//                        Uri uri = Uri.fromFile(file);
//                    }


                    //加载图片
                    Glide.with(this).load(file).into(imageView);


                }

                break;

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case PERSSION_CAEMR:

                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    //用户同意，执行操作
                    Intent openCameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    file = new File(getExternalCacheDir(), System.currentTimeMillis()+".jpg");

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                        openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                                FileProvider.getUriForFile(LoginActivity.this,"com.chen.ellen.recyclerviewitem.fileprovider", file));
                    }else {
                        openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                    }

                    startActivityForResult(openCameraIntent, REQUEST_CODE_TAKE_PICTURE);
                }else{
                    //用户不同意，向用户展示该权限作用
                    if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                        Toast.makeText(LoginActivity.this,"soory,...",Toast.LENGTH_SHORT).show();
                    }
                }

                break;
        }

    }
}
