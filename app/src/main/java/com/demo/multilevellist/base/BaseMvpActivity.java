package com.demo.multilevellist.base;


import android.os.Bundle;
import android.text.TextUtils;

import com.demo.multilevellist.R;
import com.example.frame.CommonPresenter;
import com.example.frame.ICommonModel;
import com.example.frame.ICommonView;


public abstract class BaseMvpActivity<M extends ICommonModel> extends BaseActivity implements ICommonView {

    private M mModel;
    public CommonPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutId());

        mModel = setModel();
        mPresenter = new CommonPresenter(this, mModel);
        setView();
        setUpdata();
    }

    protected abstract int setLayoutId();

    protected abstract M setModel();

    protected abstract void setUpdata();

    protected abstract void setView();

    public abstract void netSuccess(int whichApi, Object[] pD);

    @Override
    public void onSuccess(int whichApi, Object[] pD) {
        netSuccess(whichApi, pD);
    }

    @Override
    public void onFailed(int whichApi, Throwable pThrowable) {
        showLog("net work error: " + whichApi + "error content" + pThrowable != null && !TextUtils.isEmpty(pThrowable.getMessage()) ? pThrowable.getMessage() : "不明错误类型");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.clear();
    }
}