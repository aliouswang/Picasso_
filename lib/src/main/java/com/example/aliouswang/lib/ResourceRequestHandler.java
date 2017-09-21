package com.example.aliouswang.lib;

import android.content.ContentResolver;
import android.content.Context;

import java.io.IOException;

/**
 * Created by aliouswang on 2017/9/21.
 */

public class ResourceRequestHandler extends RequestHandler{
    private final Context context;

    ResourceRequestHandler(Context context) {
        this.context = context;
    }

    @Override
    public boolean canHandleRequest(Request request) {
        if (request.resourceId != 0) {
            return true;
        }
        return ContentResolver.SCHEME_ANDROID_RESOURCE.equals(request.uri.getScheme());
    }

    @Override
    public Result load(Request request, int networkPolicy) throws IOException {
        return null;
    }

}
