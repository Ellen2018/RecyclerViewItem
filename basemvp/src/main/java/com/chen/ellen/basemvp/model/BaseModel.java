package com.chen.ellen.basemvp.model;

public abstract class BaseModel<L extends LocalModel,R extends RemoteModel> {

    //本地数据
    public L localModel;
    //远程数据(网络)
    public R remoteModel;

    public BaseModel(){
        initLocalModel();
        initRemoteModel();
    }


    //初始化本地数据中心
    public abstract void initLocalModel();
    //初始化远程数据中心
    public abstract void initRemoteModel();


}



