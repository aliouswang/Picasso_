package com.example.aliouswang.picasso_;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.aliouswang.library.cache.CacheManager;
import com.example.aliouswang.library.util.OkHttp3Downloader;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "tag";

    private static final String IMAGE_URL = "http://pic2.ooopic.com/12/22/94/37bOOOPICc7_1024.jpg";

    private CacheManager cacheManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cacheManager = CacheManager.getInstance(this);

        final ImageView imageView = (ImageView) findViewById(R.id.imageView);

        final OkHttp3Downloader okHttp3Downloader = new OkHttp3Downloader();
        new AsyncTask<Void, Void, Bitmap>() {

            @Override
            protected Bitmap doInBackground(Void... voids) {
                Bitmap bitmap = null;
                if (cacheManager.isExist(IMAGE_URL)) {
                    bitmap = cacheManager.get(IMAGE_URL);
                }else {
                    bitmap = okHttp3Downloader.load(IMAGE_URL);
                    cacheManager.put(IMAGE_URL, bitmap);
                }
                return bitmap;
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                imageView.setImageBitmap(bitmap);
                super.onPostExecute(bitmap);
            }
        }.execute();


    }
}
