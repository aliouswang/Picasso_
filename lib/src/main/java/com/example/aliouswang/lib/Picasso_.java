package com.example.aliouswang.lib;

import android.net.Uri;

/**
 * Created by aliouswang on 2017/9/20.
 */

public class Picasso_ {

    public interface Listener {

        void onImageLoadFailed(Picasso_ picasso_, Uri uri, Exception exception);

    }

}
