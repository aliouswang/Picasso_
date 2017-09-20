package com.example.aliouswang.lib;

import android.net.Uri;

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

}
