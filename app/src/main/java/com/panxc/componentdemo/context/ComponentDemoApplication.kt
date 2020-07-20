package com.panxc.componentdemo.context

import com.chell.demo.common.BaseApp
import com.panxc.componentdemo.ComponentConstants

/**
 * Created by panxc on 2019-06-17.
 */
class ComponentDemoApplication : BaseApp() {

    override val appLikeNames = setOf(
        ComponentConstants.LOGIN_COMPONENT_NAME,
        ComponentConstants.ORDER_COMPONENT_NAME
    )
}
