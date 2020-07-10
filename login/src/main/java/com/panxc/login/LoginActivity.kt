package com.panxc.login

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.panxc.baselib.PrefHelper
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginButton.setOnClickListener {
            login()
        }
    }

    private fun login() {
        if (userName.text.toString().isNotEmpty() && passWord.text.toString().isNotEmpty()) {
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show()
            PrefHelper.putInt(LoginConstants.LOGIN_STATE, LoginConstants.STATE_LOGIN)
            PrefHelper.putString(LoginConstants.USER_NAME, userName.text.toString())
            finish()
        } else {
            Toast.makeText(this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show()
        }
    }
}
