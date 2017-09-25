package com.example.aliouswang.library.util;

import android.content.Context;

import java.io.File;

/**
 * Created by aliouswang on 2017/9/22.
 */

public class Utils {

    public static final String VANGOGH_CACHE = "vangogh-cache";

    public static File createDiskCacheDir(Context context) {
        File cacheFile = new File(context.getApplicationContext().getCacheDir(), VANGOGH_CACHE);
        if (!cacheFile.exists()) {
            cacheFile.mkdirs();
        }
        return cacheFile;
    }

}
