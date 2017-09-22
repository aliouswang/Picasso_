package com.example.aliouswang.library.util;

import android.graphics.Bitmap;

/**
 * Created by aliouswang on 2017/9/22.
 */

public interface Downloader {

    Bitmap load(String imageUrl);

    void shutdown();

}