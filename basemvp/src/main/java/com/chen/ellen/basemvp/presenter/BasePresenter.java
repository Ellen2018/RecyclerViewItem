package com.chen.ellen.basemvp.presenter;

import com.chen.ellen.basemvp.model.BaseModel;
import com.chen.ellen.basemvp.view.BaseView;

public abstract class BasePresenter<M extends BaseModel,V extends BaseView> {

    //Model层引用
    public M m;
    //View层引用
    public V v;

}
