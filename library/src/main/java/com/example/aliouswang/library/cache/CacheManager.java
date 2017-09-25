package com.example.aliouswang.library.cache;

import android.content.Context;
import android.graphics.Bitmap;

/**
 * Created by aliouswang on 2017/9/25.
 */

public class CacheManager implements ICache{

    private MemoryCache memoryCache;
    private DiskCache diskCache;

    private CacheManager(Context context) {
        memoryCache = new MemoryCache();
        diskCache = new DiskCache(context);
    }

    private static volatile CacheManager sInstance;

    public static CacheManager getInstance(Context context) {
        if (sInstance == null) {
            synchronized (CacheManager.class) {
                if (sInstance == null) {
                    sInstance = new CacheManager(context);
                }
            }
        }
        return sInstance;
    }


    @Override
    public void put(String key, Bitmap bitmap) {
        memoryCache.put(key, bitmap);
        diskCache.put(key, bitmap);
    }

    @Override
    public Bitmap get(String key) {
        if (memoryCache.isExist(key)) return memoryCache.get(key);
        if (diskCache.isExist(key)) return diskCache.get(key);
        return null;
    }

    @Override
    public boolean isExist(String key) {
        return memoryCache.isExist(key) || diskCache.isExist(key);
    }
}
