package com.example.frame;

import android.content.Context;


public class Host {

    private static Context mContext = FrameApplication.getFrameApplicationContext();

    public static final int API_TYPE = 3;//1,内测  2，外测  3，外正

    public static String AD_OPENAPI;

    public static String PHOTO_URL;
    public static String PHOTO_OPENAPI;


    /**
     * 静态代码块，优先于对象的创建而执行，且只执行一次
     */
    static {
        if (API_TYPE == 1){
            AD_OPENAPI = "";
            PHOTO_OPENAPI=PHOTO_URL;
        }
        if (API_TYPE == 2){
            AD_OPENAPI = "";
            PHOTO_OPENAPI=AD_OPENAPI;
        }
        if (API_TYPE == 3){
            AD_OPENAPI = mContext.getString(R.string.base_url);
        }
    }
}
