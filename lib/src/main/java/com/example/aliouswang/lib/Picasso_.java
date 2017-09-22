package com.example.aliouswang.lib;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * http://blog.csdn.net/u012702547/article/details/52273918
 *
 * Created by aliouswang on 2017/9/20.
 */

public class Picasso_ {

    public interface Listener {

        void onImageLoadFailed(Picasso_ picasso_, Uri uri, Exception exception);

    }

    public interface RequestTransformer {

        Request transformRequest(Request request);

        /**
         * which returns the original request
         */
        RequestTransformer IDENTITY = new RequestTransformer() {
            @Override
            public Request transformRequest(Request request) {
                return request;
            }
        };

    }

    public enum Priority {
        LOW,
        NORMAL,
        HIGH
    }

    static volatile Picasso_ singlton = null;

    private final Listener listener;
    private final RequestTransformer requestTransformer;
//    private final List<RequestHandler> requestHandlers;

    final Context context;
    final Dispatcher dispatcher;
    final Cache cache;
//    final Stats stats;

    final Bitmap.Config defaultBitmapConfig;

    boolean indicatorEnabled;
    volatile boolean loggingEnabled;

    boolean shutdown;

    Picasso_(Context context, Dispatcher dispatcher, Cache cache, Listener listener,
             RequestTransformer requestTransformer, List<RequestHandler> extraRequestHandlers,
             Stats stats, Bitmap.Config defaultBitmapConfig, boolean indicatorEnabled,
             boolean loggingEnabled) {
        this.context = context;
        this.dispatcher = dispatcher;
        this.cache = cache;
        this.listener = listener;
        this.requestTransformer = requestTransformer;
        this.defaultBitmapConfig = defaultBitmapConfig;

        int buildInHandlers = 7;
        int extraCount = (extraRequestHandlers != null ? extraRequestHandlers.size() : 0);
        List<RequestHandler> allRequestHandlers = new ArrayList<>(buildInHandlers + extraCount);

        allRequestHandlers.add(new ResourceRequestHandler(context));
        if (extraRequestHandlers != null) {
            allRequestHandlers.addAll(extraRequestHandlers);
        }



    }

    public enum LoadedFrom {
        MEMORY(Color.GREEN),
        DISK(Color.BLUE),
        NETWORK(Color.RED);

        final int debugColor;

        LoadedFrom(int debugColor) {
            this.debugColor = debugColor;
        }
    }

}
