package com.example.aliouswang.library;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by mac on 2017/9/25.
 */

public class Worker {

    public ExecutorService executorService;

    public Worker() {
//        executorService = Executors.newFixedThreadPool(3);
        executorService = new ThreadPoolExecutor(3, 3, 1, TimeUnit.MILLISECONDS,
                new PriorityBlockingQueue<Runnable>());
    }

    public void post(Action action) {
        executorService.execute(action);
    }

}
