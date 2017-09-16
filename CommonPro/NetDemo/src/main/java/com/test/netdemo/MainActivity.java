package com.test.netdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.test.netdemo.network.AppCall;
import com.test.netdemo.network.BaseApiSubscriber;
import com.test.netdemo.network.VersionBean;
import com.trello.rxlifecycle2.components.support.RxFragmentActivity;

public class MainActivity extends RxFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void request(View view) {
        AppCall.obtain().getVersion(new BaseApiSubscriber<VersionBean>(){
            @Override
            protected void onHandleSuccess(VersionBean versionBean) {
                Toast.makeText(MyApplication.getAppContext(), versionBean.getContent(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
