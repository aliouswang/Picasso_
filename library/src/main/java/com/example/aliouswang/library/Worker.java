package com.example.aliouswang.library;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by mac on 2017/9/25.
 */

public class Worker {

    public ExecutorService executorService;

    public Worker() {
        executorService = Executors.newFixedThreadPool(3);
    }

    public void post(Action action) {
        executorService.execute(action);
    }

}
