package com.chell.demo.order_standalone

import com.panxc.service.ILoginService

/**
 * Created by cheyuelin on 2020/7/17
 */
class LoginServiceMock : ILoginService {

    override var isLogin: Boolean = false
        get() = true

    override var userName: String = ""
        get() = "testUser"

    override fun logout() {

    }
}
