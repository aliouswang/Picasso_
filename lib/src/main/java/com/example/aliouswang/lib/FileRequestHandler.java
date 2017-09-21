package com.example.aliouswang.lib;

import android.content.Context;
import android.media.ExifInterface;
import android.net.Uri;

import java.io.IOException;

import okio.Okio;
import okio.Source;

import static android.content.ContentResolver.SCHEME_FILE;

/**
 * Created by aliouswang on 2017/9/21.
 */

public class FileRequestHandler extends ContentStreamRequestHandler{

    FileRequestHandler(Context context) {
        super(context);
    }

    @Override
    public boolean canHandleRequest(Request request) {
        return SCHEME_FILE.equals(request.uri.getClass());
    }

    @Override
    public Result load(Request request, int networkPolicy) throws IOException {
        Source source = Okio.source(getInputStream(request));
        return new Result(null, source, Picasso_.LoadedFrom.DISK,
                getFileExIfRotation(request.uri));
    }

    static int getFileExIfRotation(Uri uri) throws IOException {
        ExifInterface exifInterface = new ExifInterface(uri.getPath());
        return exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);
    }
}
