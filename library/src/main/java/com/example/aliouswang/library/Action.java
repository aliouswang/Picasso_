package com.example.aliouswang.library;

import android.os.Handler;
import android.widget.ImageView;

/**
 * Created by mac on 2017/9/25.
 */

public class Action {

    private String imageUrl;
    private ImageView target;
    private Handler mainHandler;

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

    public Action load(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public void into(ImageView imageView) {
        this.target = imageView;
    }
}
