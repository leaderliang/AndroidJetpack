package com.android.jetpack.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.jetpack.databinding.ActivityMyViewModelBinding

class MyViewModelActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMyViewModelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 方式一
        /*setContentView(R.layout.activity_my_view_model)
        mBinding = ActivityMyViewModelBinding.bind((findViewById<View>(android.R.id.content) as ViewGroup).getChildAt(0))*/

        // 方式二
        mBinding = ActivityMyViewModelBinding.inflate(layoutInflater)
        setContentView(mBinding.root)






        mBinding.tvContent.text = "测试阶段"


    }





}