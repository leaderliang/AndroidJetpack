package com.android.jetpack.observer

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.android.jetpack.util.LoggerUtil

/**
 * TODO
 *
 * Note:
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2022/08/24 17:35
 */
class Observer_ : LifecycleObserver{
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResumeListener(): Unit = LoggerUtil.d("onResume ...")

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStopListener(): Unit = LoggerUtil.d("onStop ...")
}