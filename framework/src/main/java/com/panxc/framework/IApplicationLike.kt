package com.panxc.framework

import android.content.res.Configuration

/**
 * 组件生命周期接口
 * Created by panxc on 2019-06-17.
 */

interface IApplicationLike {

    fun onCreate()

    fun onConfigurationChanged(newConfig: Configuration?) {}

    fun onLowMemory() {}

    fun onTrimMemory() {}

    fun onTerminate() {}
}
