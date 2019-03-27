package com.joyoung.viewmodel;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class MainActivity extends AppCompatActivity {

    private PersonVM mModel;
    private TextView mText;
    private NameViewModel nameModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mText = findViewById(R.id.textView);
        /**
         * Step2. 获取ViewModel 对里面的LiveData设置观察者
         */
        nameModel = ViewModelProviders.of(this).get(NameViewModel.class);
        nameModel.getCurrentName().observe(this, new Observer<String>() {
            /**
             * Step3. 当LiveData数据变化时，会通知当前观察者 带回变化的数据源
             */
            @Override
            public void onChanged(String s) {
                mText.setText(s);
                Log.d("xuhuanli", "观察到数据改变" + s);
            }
        });

        //对nameList同样设置观察者
        nameModel.getNameList().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> strings) {
                for (String string : strings) {
                    Log.d("xuhuanli", "name = " + string);
                }
            }
        });
        /*// ViewModelProviders 封装了ViewModelProvider 所以直接操作ViewModelProviders即可
        mModel = ViewModelProviders.of(this).get(PersonVM.class);
        Observer<Person> observer = new Observer<Person>() {
            @Override
            public void onChanged(Person person) {
                Log.d("xuhuanli", "数据变更" + person.toString());

            }
        };
        mModel.getLiveData().observe(this, observer);*/

        mText.setOnClickListener(new View.OnClickListener() {
            /**
             * Step4. 点击事件触发LiveData的变化 通过ViewModel拿到里面持有的LiveData
             * 然后setValue 或者postValue，从而自动通知观察者
             *  注意：setValue 主线程 postValue 子线程
             * @param v
             */
            @Override
            public void onClick(View v) {
                ArrayList<String> list = new ArrayList<>();
                for (int i = 0; i < 3; i++) {
                    list.add("name count is"+i);
                }
                nameModel.getCurrentName().setValue("xuhuanli");
                nameModel.getNameList().setValue(list);
            }
        });
    }
}
