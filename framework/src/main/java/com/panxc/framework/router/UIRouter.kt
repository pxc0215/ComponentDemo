package com.panxc.framework.router

import android.content.Context
import android.net.Uri
import android.os.Bundle

/**
 * UI短链路由
 * Created by panxc on 2019-06-17.
 */

object UIRouter : IUIRouter {

    private val uiRouters: MutableList<IUIRouter> = mutableListOf()

    override val hosts: List<String>
        get() = listOf()

    override fun openUri(context: Context, url: String, bundle: Bundle?): Boolean {
        val uri = Uri.parse(url)
        for (uiRouter in uiRouters) {
            if (uiRouter.verifyUri(uri) && uiRouter.openUri(context, url, bundle)) {
                return true
            }
        }
        return false
    }

    override fun verifyUri(uri: Uri): Boolean {
        for (uiRouter in uiRouters) {
            if (uiRouter.verifyUri(uri)) {
                return true
            }
        }
        return false
    }

    fun registerUI(router: IUIRouter?) {
        router ?: return
        uiRouters.add(router)
    }

    fun unregisterUI(router: IUIRouter?) {
        router ?: return
        uiRouters.remove(router)
    }
}
