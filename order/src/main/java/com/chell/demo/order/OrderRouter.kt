package com.chell.demo.order

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.panxc.framework.router.IUIRouter

/**
 * Created by panxc on 2019-06-21.
 */
object OrderRouter : IUIRouter {
    override val hosts: List<String>
        get() = arrayListOf("orderList")

    override fun openUri(context: Context, url: String, bundle: Bundle?): Boolean {
        val uri = Uri.parse(url)
        if (uri.host == "orderList") {
            val intent = Intent(context, OrderListActivity::class.java)
            bundle?.let {
                intent.putExtras(it)
            }
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
            return true
        }
        return false
    }
}