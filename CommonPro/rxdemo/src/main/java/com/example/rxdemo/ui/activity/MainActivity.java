package com.example.rxdemo.ui.activity;

import android.Manifest;
import android.content.Intent;
import android.view.View;

import com.example.rxdemo.R;
import com.example.rxdemo.base.BaseActivity;

import butterknife.OnClick;


public class MainActivity extends BaseActivity {


    @Override
    public int initLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initData() {
        
    }

     
    @OnClick({R.id.btnlogin})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnlogin:
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                break;
        }
    }


}
