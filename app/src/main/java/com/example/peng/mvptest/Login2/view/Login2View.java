package com.example.peng.mvptest.Login2.view;

/**
 * 第四步：定义好View接口的方法
 */

public interface Login2View{

    void shouToast(String msg);

    void onSuccess();

    String getName();

    String getPassWord();
}