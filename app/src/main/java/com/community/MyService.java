package com.community;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.community.entity.ListBean;
import com.easylib.okhttp.ResultCallback;
import com.easylib.utils.LogUtils;
import com.easylib.utils.ToastUtils;
import com.lzy.okhttputils.request.BaseRequest;

import okhttp3.Call;
import okhttp3.Response;

public class MyService extends Service {

    Handler handler = new Handler();
    Runnable runnable;
    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        runnable = new Runnable() {
            @Override
            public void run() {
                HttpUtils.getInstance().list(EasySP.getInstance().loadUserInfo().getData().getId(), new ResultCallback<ListBean>() {
                    @Override
                    public void onAfter(@Nullable ListBean listBean, @Nullable Exception e) {
                    }

                    @Override
                    public void onCacheSuccess(ListBean listBean, Call call) {

                    }

                    @Override
                    public void onBefored(BaseRequest request) {
                    }

                    @Override
                    public void onErrored(Call call, Response response, Exception e) {

                    }

                    @Override
                    public void onSuccess(ListBean listBean, Call call, Response response) {
                        if (listBean != null && listBean.getCode() == 200 && listBean.getData() != null) {
                            EasySP.getInstance().saveJoinInfo(listBean);
                            Intent dialogIntent = new Intent(getApplicationContext(), JoinClubActivity.class);
                            dialogIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(dialogIntent);
                        }
                    }
                });
                handler.postDelayed(this, 10000);
            }
        };

        handler.postDelayed(runnable, 10000);

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw null;
    }
}
