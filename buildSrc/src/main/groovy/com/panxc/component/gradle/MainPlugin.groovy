package com.panxc.component.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project

class MainPlugin implements Plugin<Project> {

    public static final String APP_PLUGIN = "com.android.application"
    public static final String LIB_PLUGIN = "com.android.library"

    private Config config

    @Override
    void apply(Project project) {
        initConfig(project.rootProject)
        configPlugin(project)
    }

    /**
     * 初始化配置
     * @param project
     */
    private void initConfig(Project project) {
        Map<String, Object> props = project.getProperties()
        config = new Config()
        config.setIsDebug(props.get(Config.KEY_DEBUG))
        config.setHost(props.get(Config.KEY_HOST))
        config.setComponents(props.get(Config.KEY_COMPONENT))
    }

    /**
     * 根据配置设置各组件app／lib模式
     * @param project
     */
    private void configPlugin(Project project) {
        if (this.config == null) {
            throw new IllegalArgumentException("config is null")
        }
        String curModule = project.path.replace(":", "")
        List<String> components = config.getComponents()
        if (config.getIsDebug()) {
            project.apply plugin: APP_PLUGIN
        } else {
            if (components.contains(curModule)) {
                project.apply plugin: LIB_PLUGIN
            } else if (config.getHost() == curModule) {
                project.apply plugin: APP_PLUGIN
                for (String module : components) {
                    project.dependencies.add("runtimeOnly", project.project(':' + module))
                }
            }
        }
    }
}