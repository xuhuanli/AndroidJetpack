package com.joyoung.androidjetpack;

import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.joyoung.androidjetpack.databinding.CustomBinding;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private User user;
    private CustomBinding dataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        user = new User();
        user.setTitle("大标题");
        user.setName("作者");
        user.setText("这里是文章的正文内容");
        user.setCount(1000);
        dataBinding.setUser(user);
        initView();
    }

    private void initView() {
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                user.setName("xuhuanli");
                user.setCount(1);
                Log.e(TAG, "setName");
                dataBinding.button1.setText("换个按钮名字");
                break;
            case R.id.button2:
                ConstraintLayout root = (ConstraintLayout) dataBinding.getRoot();
                Log.e(TAG, "root class is " + root.getClass());
                user.setCount(0);
                user.setText("我的User内容");
                break;
            case R.id.button3:
                break;
        }
    }
}
