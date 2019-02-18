package com.ybf.utileslib.utils;

/**
 * Created by ybf on 2019/1/21.
 */
public class TaskLogInfo {
    /**
     * 获取堆栈调用信息
     * @param limit = 10
     * @return
     */
    public static String LogTaskTrace(final int limit){
        final StringBuilder sb = new StringBuilder();
        try {
            throw new RuntimeException();
        } catch (final RuntimeException e) {
            final StackTraceElement[] frames = e.getStackTrace();
            // Start at 1 because the first frame is here and we don't care about it
            for (int j = 1; j < frames.length && j < limit + 1; ++j) {
                sb.append(frames[j].toString() + "\n");
            }
        }
        return sb.toString();
    }
}
