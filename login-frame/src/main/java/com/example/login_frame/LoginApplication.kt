package com.example.login_frame

import android.app.Application
import com.panxc.baselib.PrefHelper

class LoginApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initBaseLib()
    }

    private fun initBaseLib() {
        PrefHelper.init(this)
    }
}
