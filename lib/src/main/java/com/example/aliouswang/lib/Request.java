package com.example.aliouswang.lib;

import android.net.Uri;
import android.view.animation.Transformation;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by aliouswang on 2017/9/21.
 */

public final class Request {

    private static final long TOO_LONG_LOG = TimeUnit.SECONDS.toNanos(5);

    int id;
    long started;
    int networkPolicy;

    public final Uri uri;
    public final int resourceId;


    private Request(Uri uri, int resourceId, String stableKey, List<Transformation> transformations) {
        this.uri = uri;
        this.resourceId = resourceId;

    }

}
