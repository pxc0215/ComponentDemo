package com.panxc.framework.router

import android.content.Context
import android.net.Uri
import android.os.Bundle

/**
 * UIRouter接口
 * Created by panxc on 2019-06-17.
 */

interface IUIRouter {

    val hosts: List<String>

    /**
     * 打开一个链接
     *
     * @param url    目标url
     * @param bundle 打开目录activity时要传入的参数
     * @return 是否正常打开
     */
    fun openUri(context: Context, url: String, bundle: Bundle?): Boolean

    /**
     * 校验uri
     *
     * @param uri 目标uri
     * @return 是否合理
     */
    fun verifyUri(uri: Uri): Boolean = hosts.contains(uri.host)
}
