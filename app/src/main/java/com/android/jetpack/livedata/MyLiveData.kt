package com.android.jetpack.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * TODO
 *
 * Note:
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2022/08/30 15:51
 */
object MyLiveData  {

    val data : MutableLiveData<String> by lazy { MutableLiveData() }
}