package com.chell.lintcore

data class LintModel(val moduleConfigMap: Map<String, ModuleConfig>?,
                     val enableModules: List<String>)

data class ModuleConfig(val lintEnable: Boolean?,
                        val extraEnableList: List<String>?)