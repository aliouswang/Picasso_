package com.example.aliouswang.lib;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;

import java.io.FileNotFoundException;

/**
 * Created by aliouswang on 2017/9/21.
 */

public class Utils {

    static Resources getResources(Context context, Request data) throws FileNotFoundException {
        if (data.resourceId != 0 || data.uri == null) {
            return context.getResources();
        }

        String pkg = data.uri.getAuthority();
        if (pkg == null) throw new FileNotFoundException("No package provided : " + data.uri);
        try {
            PackageManager pm = context.getPackageManager();
            return pm.getResourcesForApplication(pkg);
        } catch (PackageManager.NameNotFoundException e) {
            throw new FileNotFoundException("Unable to obtain resources for package : " + data.uri);
        }
    }

    static <T> T checkNotNull(T value, String message) {
        if (value == null) {
            throw new NullPointerException(message);
        }
        return value;
    }

}
