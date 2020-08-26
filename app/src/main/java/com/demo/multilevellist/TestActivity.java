package com.demo.multilevellist;


import android.widget.TextView;

import com.demo.multilevellist.base.BaseMvpActivity;
import com.demo.multilevellist.model.CommonHomeModel;
import com.example.data.TestData;
import com.example.frame.ApiConfig;
import com.example.frame.ICommonModel;

public class TestActivity extends BaseMvpActivity {

    private TestData testData;
    private TextView tvText;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    protected ICommonModel setModel() {
        return new CommonHomeModel();
    }

    @Override
    protected void setUpdata() {
        mPresenter.getData(ApiConfig.TEST_GET);
    }

    @Override
    protected void setView() {
        tvText = findViewById(R.id.tv_text);
        tvText.setText(tvText.toString());
    }

    @Override
    public void netSuccess(int whichApi, Object[] pD) {
        switch (whichApi) {
            case ApiConfig.TEST_GET:
                TestData testData = (TestData) pD[0];
                showLog(testData.toString());
                break;
        }
    }

    private void initView() {
        tvText = (TextView) findViewById(R.id.tv_text);
    }
}