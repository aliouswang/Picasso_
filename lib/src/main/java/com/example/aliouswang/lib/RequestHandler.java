package com.example.aliouswang.lib;

import android.graphics.Bitmap;

import java.io.IOException;

import javax.xml.transform.Source;

/**
 * Created by aliouswang on 2017/9/21.
 */

public abstract class RequestHandler {

    public static final class Result {
        private final Picasso_.LoadedFrom loadedFrom;
        private final Bitmap bitmap;
        private final Source source;
        private final int exifOrientation;

        public Result(Bitmap bitmap,
                      Source source,
                      Picasso_.LoadedFrom loadedFrom,
                      int exifOrientation) {
            this.bitmap = bitmap;
            this.source = source;
            this.loadedFrom = loadedFrom;
            this.exifOrientation = exifOrientation;
        }
    }

    public abstract boolean canHandleRequest(Request request);

    public abstract Result load(Request request, int networkPolicy) throws IOException;

}
