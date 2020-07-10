package com.panxc.login.framework

import android.app.Application
import com.panxc.baselib.PrefHelper


class DebugLoginApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initBaseLib()
    }

    private fun initBaseLib() {
        PrefHelper.init(this)
    }
}
