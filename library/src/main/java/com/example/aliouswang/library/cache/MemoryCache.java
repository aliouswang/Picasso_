package com.example.aliouswang.library.cache;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

/**
 * Created by aliouswang on 2017/9/22.
 */

public class MemoryCache implements ICache{

    private LruCache<String, Bitmap> bitmapLruCache;

    public MemoryCache() {
        final int maxSize = (int) (Runtime.getRuntime().maxMemory() / 1024);
        final int cacheSize = maxSize / 8;
        bitmapLruCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getByteCount() / 1024;
            }
        };
    }

    @Override
    public void put(String key, Bitmap bitmap) {
        if (bitmap == null || isExist(key)) return;
        bitmapLruCache.put(key, bitmap);
    }

    @Override
    public Bitmap get(String key) {
        return bitmapLruCache.get(key);
    }

    @Override
    public boolean isExist(String key) {
        return get(key) != null;
    }
}
