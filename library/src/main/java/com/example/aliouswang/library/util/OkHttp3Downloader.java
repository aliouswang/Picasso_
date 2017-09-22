package com.example.aliouswang.library.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by aliouswang on 2017/9/22.
 */

public class OkHttp3Downloader implements Downloader{

    private Call call = null;

    @Override
    public Bitmap load(String imageUrl) {
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(imageUrl).build();
        try {
            call = okHttpClient.newCall(request);
            Response response = call.execute();
            byte[] bytes = response.body().bytes();
            if (bytes == null) return null;
            return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            shutdown();
        }
        return null;
    }

    @Override
    public void shutdown() {
        if (call != null && !call.isCanceled()) {
            call.cancel();
        }
    }

}
