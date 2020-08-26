package com.example.frame;

public interface ICommonView<D> {
    //成功回调
    void onSuccess(int whichApi,D... pD);
    //失败回调
    void onFailed(int whichApi,Throwable pThrowable);
}
