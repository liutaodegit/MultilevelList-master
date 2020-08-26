package com.demo.multilevellist.model;


import android.content.Context;

import com.example.frame.ApiConfig;
import com.example.frame.FrameApplication;
import com.example.frame.Host;
import com.example.frame.ICommonModel;
import com.example.frame.ICommonPresenter;
import com.example.frame.Method;
import com.example.frame.NetManger;

/**
 * Created by 任小龙 on 2020/6/4.
 */
public class CommonHomeModel implements ICommonModel {
    private NetManger mManger = NetManger.getInstance();

    @Override
    public void getData(ICommonPresenter pPresenter, int whichApi, Object[] params) {
        switch (whichApi) {
            case ApiConfig.TEST_GET:
                mManger.netWork(NetManger.mService.getTestNetWork(Host.AD_OPENAPI + Method.ADVERT_PATH), pPresenter, whichApi);
                break;
        }

    }
}
