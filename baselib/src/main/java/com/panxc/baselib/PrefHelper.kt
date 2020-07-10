package com.panxc.baselib

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by panxc on 2019-06-17.
 */
object PrefHelper {

    private lateinit var pref: SharedPreferences

    fun init(context: Context) {
        pref = context.getSharedPreferences("ComponentDemo", Context.MODE_PRIVATE)
    }

    fun putString(key: String, value: String?) {
        pref.edit().putString(key, value).apply()
    }

    fun getString(key: String, defValue: String = ""): String? {
        return pref.getString(key, defValue)
    }

    fun putInt(key: String, value: Int) {
        pref.edit().putInt(key, value).apply()
    }

    fun getInt(key: String, defValue: Int = -1): Int? {
        return pref.getInt(key, defValue)
    }
}