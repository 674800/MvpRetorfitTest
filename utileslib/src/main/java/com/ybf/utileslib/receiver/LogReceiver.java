package com.ybf.utileslib.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

import com.ybf.utileslib.utils.LogUtile;

/**
 * Created by ybf on 2019/1/21.
 */

/**
 * 通过广播修改Debug 是否开启
 * action = "com.ybf.loginfo"
 */

/**
 * 注册方法 ：LogReceiver.regerstBroadcast(this);
 */

public class LogReceiver extends BroadcastReceiver implements Action {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Log.e("LogReceiver", "action=" + action);
        if (IS_DEBUG.equals(action)) {
            LogUtile.DEBUG = true;
            LogUtile.i("LogReceiver", "LogUtile.DEBUG =" + LogUtile.DEBUG);
        }
    }

    /**
     * 注册广播
     * @param mContext
     */
    public static void regerstBroadcast(Context mContext) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(IS_DEBUG);
        LogReceiver mLogReceiver = new LogReceiver();
        mContext.registerReceiver(mLogReceiver, intentFilter);
    }
}
