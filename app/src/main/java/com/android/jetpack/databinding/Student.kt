package com.android.jetpack.databinding

import androidx.databinding.BaseObservable
import androidx.databinding.ObservableField

/**
 * TODO
 *
 * Note:
 * @author dev.liang <a href="mailto:dev.liang@outlook.com">Contact me.</a>
 * @since 2022/09/01 15:28
 */
class Student/* : BaseObservable()*/ {

    var className: String? = null
        //        @Bindable   // kotlin 不能使用次注解
        get() {
            return field
        }
        set(value) {
            field = value
//            notifyPropertyChanged(BR.className)
        }

    var age: String? = null
        get() {
            return field
        }
        set(value) {
            field = value
        }


    val classNameF: ObservableField<String> by lazy { ObservableField<String>() }
    val ageF: ObservableField<String> by lazy { ObservableField<String>() }
}