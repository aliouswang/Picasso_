package com.example.aliouswang.library;

import android.util.Log;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by aliouswang on 2017/9/26.
 */

public class PausableThreadPoolExecutor extends ThreadPoolExecutor{

    private boolean isPaused;
    private ReentrantLock lock;
    private Condition condition;

    public PausableThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        lock = new ReentrantLock();
        condition = lock.newCondition();
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        Log.e("pool_tag", "beforeExecute" + "; is paused : " + isPaused);
        super.beforeExecute(t, r);
        lock.lock();
        try {
            while (isPaused) condition.await();
            Log.e("pool_tag", "execute success");
        } catch (InterruptedException e) {
            t.interrupt();
        } finally {
            lock.unlock();
        }
    }

    public boolean isRunning() {
        return !isPaused;
    }

    public boolean isPaused() {
        return isPaused;
    }

    public void pause() {
        lock.lock();
        try {
            isPaused = true;
        } finally {
            lock.unlock();
        }
    }

    public void resume() {
        lock.lock();
        try {
            isPaused = false;
            condition.signalAll();

        } finally {
            lock.lock();

            Log.e("pool_tag", "resume success " + "; is paused : " + isPaused);
        }
    }
}
