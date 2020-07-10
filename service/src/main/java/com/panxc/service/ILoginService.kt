package com.panxc.service

/**
 * 登录组件服务
 * Created by panxc on 2019-06-17.
 */

interface ILoginService {

    /**
     * 判断是否已登录
     *
     * @return true 已登录 false 未登录
     */
    var isLogin: Boolean

    /**
     * 获取 username
     *
     * @return username
     */
    var userName: String

    /**
     * 登出
     */
    fun logout()
}
