# ComponentDemo
组件化设计 Demo

# 项目结构介绍

![架构图](https://note.youdao.com/yws/public/resource/44c2ebc2fe22cab887ac47146d3295f3/xmlnote/WEBRESOURCEe6415bfdfc9ab95c69ce2e86a8b2fe11/22009)

- baselib: 基础库，与业务无关，属于基础库层
- framework：框架库，与业务无关，存放组件化相关类，属于基础库层
- common: 提供业务层通用信息，与业务有关，属于公共服务层，但暂时没啥内容，只依赖了 baselib 和 framework
- service：提供业务层交互功能，与业务有关，属于公共服务层
- login：业务模块、业务组件，属于业务组件层
- order: 业务模块、业务组件，属于业务组件层
- app：主 module
- buildSrc: 该目录下是自定义 gradle 插件

# 基本原理
- 业务间通信通过 接口 发生
- 跳转通过 Router 路由
- 通过给业务组件"套一个壳子(application)"的方式，使得业务组件可以独立运行

# 限制耦合
- 通过自定义 lint(lintcore) 的方式，限制非法依赖
