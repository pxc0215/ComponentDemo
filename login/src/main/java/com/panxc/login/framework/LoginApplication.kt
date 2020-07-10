package com.panxc.login.framework

import com.panxc.framework.ComponentManager
import com.panxc.framework.IApplicationLike
import com.panxc.framework.router.UIRouter
import com.panxc.login.service.LoginServiceImpl
import com.panxc.service.ILoginService

/**
 * Created by panxc on 2019-06-21.
 */
class LoginApplication : IApplicationLike {

    override fun onCreate() {
        // 注册登录服务
        ComponentManager.addService(ILoginService::class.java.simpleName, LoginServiceImpl())
        // 注册路由
        UIRouter.registerUI(LoginRouter)
    }

    override fun onStop() {
        // 移除相应服务
        ComponentManager.removeService(ILoginService::class.java.simpleName)
        UIRouter.unregisterUI(LoginRouter)
    }
}