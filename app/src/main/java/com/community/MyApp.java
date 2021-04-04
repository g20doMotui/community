package com.community;

import android.app.Application;

import com.easylib.utils.AppInitUtils;

import cn.finalteam.galleryfinal.FunctionConfig;

/**
 * 作　　者: guyj
 * 修改日期: 2017/4/9
 * 描　　述:
 * 备　　注:
 */

public class MyApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        AppInitUtils.getInstance().setApplication(this).isDebug()
                .initGson()
                .initFreelineCore()
                .initLeakCanary()
                .initLogger()
                .initOkHttp()
                .initImagePicker(
                        new FunctionConfig.Builder()
                                .setEnableCamera(true)
                                .setEnableEdit(true)
                                .setEnableCrop(true)
                                .setEnablePreview(true)
                                .setMutiSelectMaxSize(9)
                                .build()
                ).create();
    }
}
