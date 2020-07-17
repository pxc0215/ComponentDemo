package com.panxc.componentdemo.context

import android.app.Application
import com.panxc.baselib.PrefHelper
import com.panxc.componentdemo.ComponentConstants
import com.panxc.framework.ComponentManager

/**
 * Created by panxc on 2019-06-17.
 */
class ComponentDemoApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initBaseLib()
        registerComponents()
    }

    private fun initBaseLib() {
        PrefHelper.init(this)
    }

    private fun registerComponents() {
        // 注册组件，同时触发组件注册自己的服务
        ComponentManager.registerComponent(ComponentConstants.LOGIN_COMPONENT_NAME)
        ComponentManager.registerComponent(ComponentConstants.ORDER_COMPONENT_NAME)
    }
}