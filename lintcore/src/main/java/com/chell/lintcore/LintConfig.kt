package com.chell.lintcore

import com.android.tools.lint.detector.api.Context
import com.google.gson.GsonBuilder
import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.IOException

class LintConfig(context: Context) {
    private var lintModel: LintModel? = null
    private val configFileName = "custom-lint-config.json"

    init {
        val configFile = getConfigFile(context.mainProject.dir)
        configFile?.let {
            lintModel = getLintModel(it)
        }
    }

    private fun getConfigFile(curDir: File): File? {
        var dir = curDir
        var configFile = File(dir, configFileName)
        while (!configFile.exists() && dir.parent != null) {
            dir = dir.parentFile
            configFile = File(dir, configFileName)
        }
        return configFile
    }

    private fun getLintModel(file: File): LintModel? {
        return try {
            val reader = BufferedReader(FileReader(file))
            val gson = GsonBuilder().create()
            gson.fromJson(reader, LintModel::class.java);
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }

    fun getEnableModules(): List<String>? {
        return lintModel?.enableModules
    }

    fun getLintModel(): LintModel? = lintModel

}