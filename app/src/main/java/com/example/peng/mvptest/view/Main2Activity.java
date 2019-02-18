package com.example.peng.mvptest.view;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.peng.mvptest.R;
import com.example.peng.mvptest.Retrf.GetRequestInterface;
import com.example.peng.mvptest.Retrf.Translation;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main2Activity extends Activity {
    private String TAG = "Translation";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        initData();

    }

    private void initData() {
        // 使用Retrofit封装的方法
        Retrofit retrofit =  new Retrofit.Builder()
                .baseUrl("https://api.douban.com/v2/")
                .addConverterFactory(GsonConverterFactory.create())//此处加入Gson数据转换器
                .build();
        // 步骤5:创建 网络请求接口 的实例
        GetRequestInterface request = retrofit.create(GetRequestInterface.class);
        Call<Translation> call = request.getCall(1220562);
        //步骤6:发送网络请求(异步)
        call.enqueue(new Callback<Translation>() {
            @Override
            public void onResponse(Call<Translation> call, Response<Translation> response) {
                Log.e(TAG, "onResponse: "+response.body().toString() );

                //加入Gson数据转换器之后，回调中直接就是需要的对象类型
                Translation translation = response.body();
                Translation.ImagesBean images = translation.getImages();

                 String imagepath = images.getSmall();
                Log.e(TAG,"imagepath ::" +imagepath);
            }

            @Override
            public void onFailure(Call<Translation> call, Throwable t) {
                Log.e(TAG,"onFailure"+t.toString());
            }
        });
    }
}
