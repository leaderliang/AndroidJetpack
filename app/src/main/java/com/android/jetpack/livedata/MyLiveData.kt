package com.android.jetpack.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * LiveData与MutableLiveData区别
 * LiveData与MutableLiveData的其实在概念上是一模一样的，唯一几个的区别如下:
 * MutableLiveData的父类是LiveData
 * LiveData在实体类里可以通知指定某个字段的数据更新.
 * MutableLiveData则是完全是整个实体类或者数据类型变化后才通知，不会细节到某个字段
 *
 * Note:
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2022/08/30 15:51
 */
object MyLiveData {

    // 用到懒加载，用到再加载
    val data: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val data1: MutableLiveData<String> by lazy { MutableLiveData() }
}