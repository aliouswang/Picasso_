package com.example.aliouswang.library;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/**
 * Created by aliouswang on 2017/9/22.
 */

public class VanGogh {

    private static Worker sWorker = new Worker();

    public static Worker getWorker() {
        return sWorker;
    }

    private static Handler mainHandler = new Handler(Looper.myLooper()) {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Action action = (Action) msg.obj;
            int what = msg.what;
            if (what == MESSAGE.SUCCESS.flag) {
                action.getTarget().setImageBitmap(action.getBitmap());
            }
        }
    };

    public static Action with(Context context) {
        Action action = new Action();
        action.setWorker(sWorker);
        action.setMainHandler(mainHandler);
        return action;
    }

    public enum MESSAGE {

        SUCCESS(1);

        int flag;

        MESSAGE(int flag) {
            this.flag = flag;
        }
    }


}
