package com.ybf.utileslib.utils;

import android.util.Log;

/**
 * Created by ybf on 2019/1/21.
 * Log工具类
 */
public class LogUtile  {
    public static Boolean DEBUG = true;

    public static void i(String TAG, String msg) {
        if (DEBUG) {
            Log.i(TAG, msg);
        }
    }

    public static void d(String TAG, String msg) {
        if (DEBUG) {
            Log.d(TAG, msg);
        }
    }

    public static void e(String TAG, String msg) {
        if (DEBUG) {
            Log.e(TAG, msg);
        }
    }

    public static void w(String TAG, String msg) {
        if (DEBUG) {
            Log.w(TAG, msg);
        }
    }

    public static void v(String TAG, String msg) {
        if (DEBUG) {
            Log.v(TAG, msg);
        }
    }

    /**
     * 根据tag打印相关v信息
     * @param tag
     * @param msg
     */
    public static void V(String tag,String msg)
    {
        if(DEBUG){
            StackTraceElement ste = new Throwable().getStackTrace()[1];
            String traceInfo = ste.getClassName() + "::";
            traceInfo += ste.getMethodName();
            traceInfo += "@" + ste.getLineNumber() + ">>";
            android.util.Log.v(tag, traceInfo+msg);
        }
    }

}
