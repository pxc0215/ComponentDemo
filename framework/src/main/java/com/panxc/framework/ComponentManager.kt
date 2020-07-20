package com.panxc.framework

/**
 * 组件管理器，负责组件的注册、删除，并维护组件中接口的注册、删除
 * Created by panxc on 2019-06-17.
 */
object ComponentManager {

    // 注册组件集合
    private val components = mutableMapOf<String, IApplicationLike>()
    // 注册的接口集合
    private val services = mutableMapOf<String, Any>()

    /**
     * 注册服务
     *
     * @param serviceName 服务简单类名
     * @param serviceImpl 服务实例
     */
    fun addService(serviceName: String, serviceImpl: Any) {
        services[serviceName] = serviceImpl
    }

    /**
     * 移除服务
     *
     * @param serviceName 服务简单类名
     */
    fun removeService(serviceName: String) {
        services.remove(serviceName)
    }

    /**
     * 获取服务
     *
     * @param clazz 类
     * @param <T>   泛型
     * @return 服务实例
     */
    fun <T> getService(clazz: Class<T>?): T? {
        val o = services[clazz?.simpleName]
        return o as T
    }
}
