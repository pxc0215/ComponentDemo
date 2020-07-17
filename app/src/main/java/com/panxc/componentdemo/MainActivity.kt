package com.panxc.componentdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.panxc.framework.ComponentManager
import com.panxc.framework.router.UIRouter
import com.panxc.service.ILoginService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        initView()
    }

    private fun initView() {
        val loginService = ComponentManager.getService(ILoginService::class.java)
        textUserInfo.text = if (loginService != null && loginService.isLogin) loginService.userName else "点击登录"
        textUserInfo.setOnClickListener {
            if (loginService !== null && loginService.isLogin) {
                loginService.logout()
                textUserInfo.text = "点击登录"
                Toast.makeText(this, "退出成功", Toast.LENGTH_SHORT).show()
            } else {
                // TODO 这里的跳转可以通过 service 获取 url 或者通过 service 跳转
                UIRouter.openUri(this, "component://login", null)
            }
        }

        order_tv.setOnClickListener {
            UIRouter.openUri(this, "component://orderList", null)
        }
    }
}
