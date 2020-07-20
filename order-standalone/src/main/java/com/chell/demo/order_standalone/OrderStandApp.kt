package com.chell.demo.order_standalone

import com.chell.demo.common.BaseApp
import com.chell.demo.order.OrderApp
import com.panxc.framework.ComponentManager
import com.panxc.service.ILoginService

/**
 * Created by cheyuelin on 2020/7/17
 */
class OrderStandApp : BaseApp() {

    override val appLike = OrderApp()

    override fun onCreate() {
        super.onCreate()
        ComponentManager.addService(ILoginService::class.java.simpleName, LoginServiceMock())
    }
}
