package com.android.jetpack.activity

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.android.jetpack.R
import com.android.jetpack.databinding.ActivityLifecycleBinding
import com.android.jetpack.livedata.MyLiveData
import com.android.jetpack.observer.MyObserver
import com.android.jetpack.observer.Observer_
import com.android.jetpack.util.LoggerUtil
import kotlinx.android.synthetic.main.activity_lifecycle.*
import kotlin.concurrent.thread

class LifecycleActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityLifecycleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // viewBinding 两种使用方式
        /*setContentView(R.layout.activity_lifecycle)
        mBinding = ActivityLifecycleBinding.bind((findViewById<View>(android.R.id.content) as ViewGroup).getChildAt(0))
        */

        /*mBinding = ActivityLifecycleBinding.inflate(layoutInflater)
        setContentView(mBinding.root)*/

        setContentView(R.layout.activity_lifecycle)
        mBinding = ActivityLifecycleBinding.inflate(layoutInflater)
        ActivityLifecycleBinding.bind(mBinding.root)

        // import kotlinx.android.synthetic.main.activity_lifecycle.*
        tv_name.text = "from android extensions"




        lifecycle.addObserver(Observer_())
        // 观察生命周期变化
        lifecycle.addObserver(MyObserver())


        MyLiveData.data.observe(this) {
            LoggerUtil.d("观察数据变化 {$it}")
        }



        MyLiveData.data.observe(this, object : Observer<String> {
            override fun onChanged(t: String?) {

            }

        })

        // 一直执行
        MyLiveData.data.observeForever({

        })



        MyLiveData.data.value = "111222"

        thread {
            // 子线程发送消息
            MyLiveData.data.postValue("111222")
        }

    }


}


