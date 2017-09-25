package com.example.aliouswang.library;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ImageView;

/**
 * Created by aliouswang on 2017/9/22.
 */

public class VanGogh {

    private static Handler mainHandler = new Handler(Looper.myLooper()) {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    public static Action with(Context context) {
        Action action = new Action();
        action.setMainHandler(mainHandler);
        return action;
    }




}
