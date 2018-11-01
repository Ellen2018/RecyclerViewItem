package com.chen.ellen.basemvp.view;

import android.support.v7.app.AppCompatActivity;

import com.chen.ellen.basemvp.presenter.BasePresenter;
import com.chen.ellen.basemvp.view.BaseView;

import javax.inject.Inject;

public class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView {



    @Inject
    public P p;

}
