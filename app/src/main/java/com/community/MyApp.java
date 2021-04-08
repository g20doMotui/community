package com.community;

import android.app.Application;
import android.content.Intent;

import com.easylib.utils.AppInitUtils;

import cn.finalteam.galleryfinal.FunctionConfig;


public class MyApp extends Application{

    static Intent serviceIntent;
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

        serviceIntent = new Intent(this, MyService.class);
    }
}
