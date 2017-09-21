package com.example.aliouswang.lib;

import android.content.ContentResolver;
import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import okio.Okio;
import okio.Source;

import static android.content.ContentResolver.SCHEME_CONTENT;

/**
 * Created by aliouswang on 2017/9/21.
 */

public class ContentStreamRequestHandler extends RequestHandler{
    final Context context;

    ContentStreamRequestHandler(Context context) {
        this.context = context;
    }

    @Override
    public boolean canHandleRequest(Request request) {
        return SCHEME_CONTENT.equals(request.uri.getScheme());
    }

    @Override
    public Result load(Request request, int networkPolicy) throws IOException {
        Source source = Okio.source(getInputStream(request));
        return new Result(source, Picasso_.LoadedFrom.DISK);
    }

    InputStream getInputStream(Request request) throws FileNotFoundException {
        ContentResolver contentResolver = context.getContentResolver();
        return contentResolver.openInputStream(request.uri);
    }
}
