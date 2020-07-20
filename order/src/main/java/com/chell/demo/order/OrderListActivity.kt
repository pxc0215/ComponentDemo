package com.chell.demo.order

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.panxc.framework.ComponentManager
import com.panxc.service.ILoginService
import kotlinx.android.synthetic.main.activity_order_list.*

/**
 * Created by cheyuelin on 2020/7/17
 */
class OrderListActivity : AppCompatActivity() {
    private val loginService = ComponentManager.getService(ILoginService::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_list)

        loginService?.apply {
            if (isLogin) {
                login_status_tv.text = "已登录"
                list_order.visibility = View.VISIBLE
            } else {
                login_status_tv.text = "未登录"
                list_order.visibility = View.GONE
            }
            name_tv.text = userName

        }
    }


}