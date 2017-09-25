package com.example.aliouswang.library.cache;

import android.content.Context;
import android.graphics.Bitmap;

import com.example.aliouswang.library.util.Utils;

import java.io.File;

/**
 * Created by aliouswang on 2017/9/22.
 */

public class DiskCache implements ICache{

    String mCacheDirPath;

    public DiskCache(Context context) {
        File cacheDir = Utils.createDiskCacheDir(context);
        this.mCacheDirPath = cacheDir.getAbsolutePath();
    }

    @Override
    public void put(String key, Bitmap bitmap) {
        if (bitmap == null) return;

    }

    @Override
    public Bitmap get(String key) {
        return null;
    }

    @Override
    public boolean isExist(String key) {
        return false;
    }

}
