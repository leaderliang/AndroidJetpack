package com.android.jetpack.viewmodel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.android.jetpack.User;

/**
 * TODO
 * <p>
 * Note:
 *
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2022/08/23 15:53
 */
public class UserModel extends /*ViewModel*/  AndroidViewModel {
    private final MutableLiveData<User> userLiveData = new MutableLiveData<>();
    private Context context;


    public UserModel(@NonNull Application application) {
        super(application);
        this.context = application;
    }

    public LiveData<User> getUser() {
        return userLiveData;
    }

    /*public UserModel() {
        // trigger user load.
    }*/

    public void doAction() {
        // depending on the action, do necessary business logic calls and update the
        // userLiveData.
        User user = new User();
        user.setName("liang");
        user.setAge(29);
        userLiveData.postValue(user);
    }
}
