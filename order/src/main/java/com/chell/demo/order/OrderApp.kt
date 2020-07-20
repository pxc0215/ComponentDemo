package com.chell.demo.order

import com.panxc.framework.IApplicationLike
import com.panxc.framework.router.UIRouter

/**
 * Created by cheyuelin on 2020/7/17
 */
class OrderApp : IApplicationLike {

    override fun onCreate() {
        //register order service
        UIRouter.registerUI(OrderRouter)

    }

}
