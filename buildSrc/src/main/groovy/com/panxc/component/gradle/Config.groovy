package com.panxc.component.gradle

/**
 * 编译配置参数数据结构
 */
final class Config {

    public static final String KEY_DEBUG = "isDebug"
    public static final String KEY_HOST = "host"
    public static final String KEY_COMPONENT = "component"

    //是否是调试模式
    private boolean isDebug
    //主项目名称
    private String host
    //组件名称集合
    private List<String> components = new ArrayList<>()

    boolean getIsDebug() {
        return isDebug
    }

    void setIsDebug(String isDebug) {
        this.isDebug = Boolean.valueOf(isDebug)
    }

    String getHost() {
        return host
    }

    void setHost(String host) {
        this.host = host
    }

    List<String> getComponents() {
        return components
    }

    void setComponents(String components) {
        if (components == null) {
            return
        }
        this.components.clear()
        String[] ss = components.split(",")
        for (String s : ss) {
            if (s != null) {
                this.components.add(s)
            }
        }
    }
}