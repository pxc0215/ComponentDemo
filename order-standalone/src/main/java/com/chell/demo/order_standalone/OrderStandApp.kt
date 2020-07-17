package com.chell.demo.order_standalone

import com.chell.demo.order.OrderApp
import com.panxc.framework.ComponentManager
import com.panxc.service.ILoginService

/**
 * Created by cheyuelin on 2020/7/17
 */
class OrderStandApp : OrderApp() {

    override fun onCreate() {
        super.onCreate()
        ComponentManager.addService(ILoginService::class.java.simpleName, LoginServiceMock())

    }
}