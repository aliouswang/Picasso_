package com.example.aliouswang.library;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import com.example.aliouswang.library.cache.CacheManager;
import com.example.aliouswang.library.util.OkHttp3Downloader;

/**
 * Created by mac on 2017/9/25.
 */

public class Action implements Runnable{

    private String imageUrl;
    private ImageView target;
    private Handler mainHandler;
    private Worker worker;
    private Bitmap bitmap;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ImageView getTarget() {
        return target;
    }

    public void setTarget(ImageView traget) {
        this.target = traget;
    }

    public Handler getMainHandler() {
        return mainHandler;
    }

    public void setMainHandler(Handler mainHandler) {
        this.mainHandler = mainHandler;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public Action load(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public void into(ImageView imageView) {
        this.target = imageView;
        worker.post(this);
    }

    @Override
    public void run() {
        boolean isCached = CacheManager.getInstance(target.getContext())
                .isExist(imageUrl);
        if (isCached) {
            this.bitmap = CacheManager.getInstance(target.getContext())
                    .get(imageUrl);
        }else {
            OkHttp3Downloader okHttp3Downloader = new OkHttp3Downloader();
            this.bitmap = okHttp3Downloader.load(imageUrl);
        }
        Message message = this.mainHandler.obtainMessage();
        message.what = VanGogh.MESSAGE.SUCCESS.flag;
        message.obj = this;
        this.mainHandler.sendMessage(message);
    }
}
