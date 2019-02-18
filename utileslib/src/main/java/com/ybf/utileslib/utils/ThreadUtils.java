package com.ybf.utileslib.utils;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 类： 不要每次都去new thread  直接使用线程池，使用空间换时间
 * Created by ybf on 2019/2/15.
 */
public class ThreadUtils {

    /**
     * thread 为子线程
     * 拿到主线程looper，才回在主线程执行
     */
    private static Handler sHandler = new Handler(Looper.getMainLooper());
    /**
     * 维护单线程池
     */
    private static Executor sExecutor = Executors.newSingleThreadExecutor();
    /**
     * 维护指定书线程池
     */
    private  static Executor sMorExecutors = Executors.newFixedThreadPool(3);

    public static ThreadUtils instance = new ThreadUtils();
    public static ThreadUtils getInstance(){
        return instance;
    }
    /**
     * 维护单线程池的调用方法
     * @param runnable
     */
    public static void runOnSubThread(Runnable runnable){
        sExecutor.execute(runnable);
    }

    /**
     * 子线程中调用
     * @param runnable
     */
    public static void runOnMainThread(Runnable runnable){
        sHandler.post(runnable);

    }

}
