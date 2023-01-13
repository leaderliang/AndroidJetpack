package com.android.jetpack.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

/**
 * TODO
 *
 * Note:
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2023/01/13 11:50
 */
class MyViewModelSavedStateHandle(private val savedStateHandle: SavedStateHandle) : ViewModel() {
    /*val userLiveData = MutableLiveData<Int>()

    val userLiveData_ : MutableLiveData<Int> by lazy {
        MutableLiveData()
    }*/


    private val userLiveData1 = MutableLiveData<Int>().also {
        if(!savedStateHandle.contains("testKey")){
            savedStateHandle["testKey"] = -1
        }
        it.value = savedStateHandle["testKey"]
    }

    val publicUserLiveData: LiveData<Int> = userLiveData1

    fun btAddNum(){
        userLiveData1.value = userLiveData1.value?.plus(1)
        savedStateHandle["testKey"] = userLiveData1.value
    }

}