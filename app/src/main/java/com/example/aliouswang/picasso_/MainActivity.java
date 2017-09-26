package com.example.aliouswang.picasso_;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.aliouswang.library.VanGogh;
import com.example.aliouswang.library.cache.CacheManager;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "tag";

    private static final String IMAGE_URL = "http://pic2.ooopic.com/12/22/94/37bOOOPICc7_1024.jpg";

    private CacheManager cacheManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ImageAdapter imageAdapter = new ImageAdapter();
        recyclerView.setAdapter(imageAdapter);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    Log.e("pool_tag", "SCROLL_STATE_IDLE");
                    VanGogh.getWorker().resume();
                }else {
                    Log.e("pool_tag", "other state");
                    VanGogh.getWorker().pause();
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });

//        final OkHttp3Downloader okHttp3Downloader = new OkHttp3Downloader();
//        new AsyncTask<Void, Void, Bitmap>() {
//
//            @Override
//            protected Bitmap doInBackground(Void... voids) {
//                Bitmap bitmap = null;
//                if (cacheManager.isExist(IMAGE_URL)) {
//                    bitmap = cacheManager.get(IMAGE_URL);
//                }else {
//                    bitmap = okHttp3Downloader.load(IMAGE_URL);
//                    cacheManager.put(IMAGE_URL, bitmap);
//                }
//                return bitmap;
//            }
//
//            @Override
//            protected void onPostExecute(Bitmap bitmap) {
//                imageView.setImageBitmap(bitmap);
//                super.onPostExecute(bitmap);
//            }
//        }.execute();


    }
}
