package com.panxc.login.service

import com.panxc.baselib.PrefHelper
import com.panxc.login.LoginConstants
import com.panxc.service.ILoginService

/**
 * Created by panxc on 2019-06-17.
 */
class LoginServiceImpl : ILoginService {

    override var isLogin: Boolean = false
        get() = PrefHelper.getInt(LoginConstants.LOGIN_STATE) == LoginConstants.STATE_LOGIN

    override var userName: String = ""
        get() = PrefHelper.getString(LoginConstants.USER_NAME, "") ?: ""

    override fun logout() {
        PrefHelper.putInt(LoginConstants.LOGIN_STATE, LoginConstants.STATE_LOGOUT)
        PrefHelper.putString(LoginConstants.USER_NAME, "")
    }
}