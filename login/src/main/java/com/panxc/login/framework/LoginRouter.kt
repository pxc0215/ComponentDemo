package com.panxc.login.framework

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.panxc.framework.router.IUIRouter
import com.panxc.login.LoginActivity

/**
 * Created by panxc on 2019-06-21.
 */
object LoginRouter : IUIRouter {
    override val hosts: List<String>
        get() = arrayListOf("login")

    override fun openUri(context: Context, url: String, bundle: Bundle?): Boolean {
        val uri = Uri.parse(url)
        if (uri.host == "login") {
            val intent = Intent(context, LoginActivity::class.java)
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