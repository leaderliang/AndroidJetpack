package com.android.jetpack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.jetpack.observer.MyObserver;

/**
 * 注意：ViewModel 绝不能引用视图、Lifecycle 或可能存储对 Activity 上下文的引用的任何类。
 *
 * @author devliang
 * @hide
 */
public class MainActivity extends AppCompatActivity {

    private LiveDataTimerViewModel mLiveDataTimerViewModel;
    private UserModel userModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        testTimerViewModel();
//        testUserModel();

        getLifecycle().addObserver(new MyObserver());
    }

    private void testTimerViewModel() {
        // mLiveDataTimerViewModel = ViewModelProviders.of(this).get(LiveDataTimerViewModel.class);
        mLiveDataTimerViewModel = new ViewModelProvider(this).get(LiveDataTimerViewModel.class);
        mLiveDataTimerViewModel.getElapsedTime().observe(this, new Observer<Long>() {
            @Override
            public void onChanged(Long aLong) {
                String newText = getResources().getString(R.string.second, aLong);
                ((TextView) findViewById(R.id.tv_time)).setText(newText);
                Log.d("MainActivity", "Updating timer:" + aLong);
            }
        });
    }

    private void testUserModel() {
        userModel = new ViewModelProvider(this).get(UserModel.class);
        userModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                Log.d("MainActivity", "userModel:" + user.toString());
            }
        });
    }

    public void onUserModelClick(View view) {
        userModel.doAction();
    }
}