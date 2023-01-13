package com.android.jetpack.activity

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.android.jetpack.R
import com.android.jetpack.databinding.ActivityDatabindingKtTestBinding
import com.android.jetpack.databinding.Student
import com.android.jetpack.util.LoggerUtil

/**
 * TODO
 *
 * Note:
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2022/09/01 15:25
 */
class DatabindingTestActivityKt : AppCompatActivity() {

    private val student = Student()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityDatabindingKtTestBinding>(
            this,
            R.layout.activity_databinding_kt_test
        )

        student.className = "liangyy"
        student.age = "29"
        binding.student = student

        // 不会改变
        Handler().postDelayed({
            student.className = "devliang"
            student.age = "29"
        }, 3000)


        LoggerUtil.d("name :${student.classNameF.get()}, age: ${student.ageF}")

        Handler().postDelayed({
            student.classNameF.set("devliang@outlook.com")
            student.ageF.set("29")
        }, 3000)


        student.classNameF.set("三年二班")
        student.ageF.set("29")
//        binding.student = student
        LoggerUtil.d("name :${student.classNameF.get()}, age: ${student.ageF}")



        Handler().postDelayed({
            LoggerUtil.d("name :${student.classNameF.get()}, age: ${student.ageF}")
        }, 5000)


    }
}