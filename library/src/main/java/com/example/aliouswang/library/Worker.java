package com.example.aliouswang.library;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by mac on 2017/9/25.
 */

public class Worker {

    public PausableThreadPoolExecutor executorService;

    public Worker() {
//        executorService = Executors.newFixedThreadPool(3);
//        executorService = new ThreadPoolExecutor(5, 5, 1, TimeUnit.MILLISECONDS,
//                new PriorityBlockingQueue<Runnable>());

        executorService = new PausableThreadPoolExecutor(5, 5, 1, TimeUnit.MILLISECONDS,
                new PriorityBlockingQueue<Runnable>());
    }

    public void post(Action action) {
        executorService.execute(action);
    }


    public void pause() {
        executorService.pause();
    }

    public void resume() {
        executorService.resume();
    }
}
