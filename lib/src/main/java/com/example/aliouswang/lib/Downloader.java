package com.example.aliouswang.lib;

import java.io.IOException;

import okhttp3.*;

/**
 * Created by aliouswang on 2017/9/22.
 */

public interface Downloader {

    Response load(okhttp3.Request request) throws IOException;

    void shutdown();

}
