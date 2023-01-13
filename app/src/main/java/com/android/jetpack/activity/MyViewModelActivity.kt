package com.android.jetpack.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.android.jetpack.databinding.ActivityMyViewModelBinding
import com.android.jetpack.viewmodel.MyViewModel
import com.android.jetpack.viewmodel.MyViewModelSavedStateHandle

class MyViewModelActivity : AppCompatActivity() {
    private lateinit var myViewModel: MyViewModel
    private lateinit var mBinding: ActivityMyViewModelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 方式一
        /*setContentView(R.layout.activity_my_view_model)
        mBinding = ActivityMyViewModelBinding.bind((findViewById<View>(android.R.id.content) as ViewGroup).getChildAt(0))*/

        // 方式二
        mBinding = ActivityMyViewModelBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        //  实例化 viewModel 的其中两种方式
//            myViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(MyViewModel::class.java)

        /*
        by viewModels<MyViewModel>()  这种形式需要在 app 下的 gradle 文件中添加对应配置
        kotlinOptions{
            jvmTarget = 1.8
        }
        并且添加对应依赖      implementation 'androidx.fragment:fragment-ktx:1.3.5'
        */
//        val viewModel by viewModels<MyViewModel>()
        val viewModel by viewModels<MyViewModelSavedStateHandle>()

        viewModel.publicUserLiveData.observe(this) {
            mBinding.tvContent.text = it.toString()
        }





        mBinding.btChange.setOnClickListener {
            viewModel.btAddNum()
        }


    }





}