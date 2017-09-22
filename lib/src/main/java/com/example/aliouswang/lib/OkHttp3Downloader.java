package com.example.aliouswang.lib;

import java.io.IOException;

import okhttp3.*;
import okhttp3.Cache;
import okhttp3.Request;

/**
 * Created by aliouswang on 2017/9/22.
 */

public class OkHttp3Downloader implements Downloader{

    private Call.Factory client;
    private final Cache cache;
    private boolean sharedClient = true;

    public OkHttp3Downloader(OkHttpClient client) {
        this.client = client;
        this.cache = client.cache();
    }

    @Override
    public Response load(Request request) throws IOException {
        return null;
    }

    @Override
    public void shutdown() {

    }
}
