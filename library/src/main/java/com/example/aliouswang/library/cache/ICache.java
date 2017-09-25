package com.example.aliouswang.library.cache;

import android.graphics.Bitmap;

/**
 * Created by aliouswang on 2017/9/22.
 */

public interface ICache {

    void put(String key, Bitmap bitmap);

    Bitmap get(String key);

    boolean isExist(String key);

}
