package com.android.jetpack.observer

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.android.jetpack.util.LoggerUtil

/**
 * TODO
 *
 * Note:
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2022/08/24 15:05
 */
class MyObserver : DefaultLifecycleObserver /*FullLifecycleObserver*/ {

    fun onResumeListener(): Unit = LoggerUtil.d("onResume ...")

    fun onStopListener(): Unit = LoggerUtil.d("onStop ...")

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        LoggerUtil.d("onCreate ...")
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        LoggerUtil.d("onStart ...")
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        LoggerUtil.d("onResume ...")
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        LoggerUtil.d("onPause ...")
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        LoggerUtil.d("onStop ...")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        LoggerUtil.d("onDestroy ...")
    }


}