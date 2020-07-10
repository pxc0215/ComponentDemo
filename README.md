# ComponentDemo
组件化设计 Demo：动态修改 Android Gradle 插件

# 项目结构介绍
- baselib: 基础库，与业务无关，属于基础库层
- framework：框架库，与业务无关，存放组件化相关类，属于基础库层
- common: 提供业务层通用信息，与业务有关，属于公共服务层，但暂时没啥内容，只依赖了 baselib 和 framework
- service：提供业务层交互功能，与业务有关，属于公共服务层
- login：业务模块、业务组件，属于业务组件层
- app：主 module
- buildSrc: 该目录下是自定义 gradle 插件

# 基本原理
- 业务间通信通过 接口 发生
- 跳转通过 Router 路由
- 通过自定义 gradle 插件，实现业务组件独立运行：在 debug 模式下，动态修改业务组件的 android gradle 插件，使其作为 application 运行；在 release 模式下，修改为 library，并被 app 依赖；
