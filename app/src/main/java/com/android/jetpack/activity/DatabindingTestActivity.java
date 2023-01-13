package com.android.jetpack.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.android.jetpack.R;
import com.android.jetpack.databinding.ActivityDatabindingTestBinding;
import com.android.jetpack.databinding.User;

public class DatabindingTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_databinding_test);
        // 下面这行直接替换 setContentView(R.layout.activity_databinding_test);
        ActivityDatabindingTestBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_databinding_test);

        User user = new User("liang", "29");
        binding.setUser(user);


//        binding.setLifecycleOwner(this);// databinding 和 livedata 进行关联 感应 结合
    }
}