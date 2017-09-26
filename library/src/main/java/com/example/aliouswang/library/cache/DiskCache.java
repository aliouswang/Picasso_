package com.example.aliouswang.library.cache;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.aliouswang.library.util.MD5Util;
import com.example.aliouswang.library.util.Utils;
import com.jakewharton.disklrucache.DiskLruCache;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by aliouswang on 2017/9/22.
 */

public class DiskCache implements ICache{

    private static final int DISK_CACHE_SIZE = 1024 * 1024 * 100;  //10MB
    String mCacheDirPath;
    private DiskLruCache mDiskLruCache;

    public DiskCache(Context context) {
        File cacheDir = Utils.createDiskCacheDir(context);
        this.mCacheDirPath = cacheDir.getAbsolutePath();
        try {
            mDiskLruCache = DiskLruCache.open(cacheDir, getAppVersion(context), 1, DISK_CACHE_SIZE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int getAppVersion(Context context) {
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0);
            return info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public void put(String key, Bitmap bitmap) {
        if (bitmap == null) return;
        String md5Key = MD5Util.md5(key);
        try {
            DiskLruCache.Editor editor = mDiskLruCache.edit(md5Key);
            OutputStream outputStream = editor.newOutputStream(0);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
            editor.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Bitmap get(String key) {
        String md5Key = MD5Util.md5(key);
        try {
            DiskLruCache.Snapshot snapshot = mDiskLruCache.get(md5Key);
            if (snapshot != null) {
                InputStream inputStream = snapshot.getInputStream(0);
                return BitmapFactory.decodeStream(inputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean isExist(String key) {
        String md5Key = MD5Util.md5(key);
        try {
            DiskLruCache.Snapshot snapshot = mDiskLruCache.get(md5Key);
            return snapshot != null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

//    private File getCacheDir(Context context, String fileName) {
//        final String cachePath =
//                Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) ?
//                      Environment.getExternalStorageDirectory().getAbsolutePath() :
//
//    }

}
