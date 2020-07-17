package com.chell.demo.order

import android.app.Application
import com.panxc.framework.IApplicationLike
import com.panxc.framework.router.UIRouter

/**
 * Created by cheyuelin on 2020/7/17
 */
open class OrderApp : Application(), IApplicationLike {

    override fun onCreate() {
        super.onCreate()
        //register order service
        UIRouter.registerUI(OrderRouter)

    }

    override fun onStop() {
        UIRouter.unregisterUI(OrderRouter)
    }

}