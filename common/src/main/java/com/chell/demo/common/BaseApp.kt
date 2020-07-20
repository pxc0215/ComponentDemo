package com.chell.demo.common

import android.app.Application
import android.content.res.Configuration
import com.panxc.baselib.PrefHelper
import com.panxc.framework.IApplicationLike

/**
 * Created by cheyuelin on 2020/7/17
 */
open class BaseApp : Application() {
    private val appLikes = mutableSetOf<IApplicationLike>()

    open val appLikeNames: Set<String>? = null

    open val appLike: IApplicationLike? = null

    override fun onCreate() {
        super.onCreate()
        if (appLikeNames != null && appLike != null) {
            throw IllegalStateException("Don't set appLikeNames and appLike at same time!")
        }
        initBaseLib()

        appLike?.let {
            appLikes.add(it)
            it.onCreate()
        }

        appLikeNames?.forEach {
            try {
                val clazz = Class.forName(it)
                val appLike = clazz.newInstance() as IApplicationLike
                appLikes.add(appLike)
                appLike.onCreate()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        appLikes.forEach {
            it.onConfigurationChanged(newConfig)
        }
    }

    override fun onLowMemory() {
        super.onLowMemory()
        appLikes.forEach {
            it.onLowMemory()
        }
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        appLikes.forEach {
            it.onTrimMemory()
        }
    }

    override fun onTerminate() {
        super.onTerminate()
        appLikes.forEach {
            it.onTerminate()
        }
    }

    private fun initBaseLib() {
        PrefHelper.init(this)
    }
}