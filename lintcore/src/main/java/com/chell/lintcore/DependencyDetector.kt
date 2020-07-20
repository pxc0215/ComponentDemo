package com.chell.lintcore

import com.android.tools.lint.detector.api.*

class DependencyDetector : Detector(), GradleScanner {
    private lateinit var lintConfig: LintConfig
    private lateinit var moduleName: String

    companion object {
        val ILLEGALDEPENDENCY = Issue.create(
                id = "IllegalDependency",
                briefDescription = "非法依赖",
                explanation = """
                This detector looks for deprecated Gradle constructs which currently work \
                but will likely stop working in a future update.""",
                category = Category.CORRECTNESS,
                priority = 6,
                androidSpecific = true,
                severity = Severity.ERROR,
                implementation = Implementation(DependencyDetector::class.java, Scope.GRADLE_SCOPE)
        )
    }

    override fun beforeCheckRootProject(context: Context) {
        lintConfig = LintConfig(context)
        moduleName = context.mainProject.name
    }

    override fun checkDslPropertyAssignment(
            context: GradleContext,
            property: String,
            value: String,
            parent: String,
            parentParent: String?,
            valueCookie: Any,
            statementCookie: Any
    ) {
        if (parent == "dependencies") {
            if (value.startsWith("project")) {
                val dependency = getProjectDependencyValue(value)
                dependency?.let {
                    val enableModules = lintConfig.getEnableModules()?.toMutableList()
                            ?: mutableListOf()
                    val lintModel = lintConfig.getLintModel()
                    val moduleConfig = lintModel?.moduleConfigMap?.get(moduleName)
                    moduleConfig?.let { config ->
                        if (config.lintEnable != null && config.lintEnable) {
                            config.extraEnableList?.let { list ->
                                enableModules.addAll(list)
                                if (enableModules.isNotEmpty() && !enableModules.contains(it)) {
                                    report(context, valueCookie, ILLEGALDEPENDENCY, "非法依赖")
                                }
                            }
                        }
                    }
                }

            }
        }
    }

    private fun getProjectDependencyValue(value: String): String? {
        val start = value.indexOf("(")
        val end = value.indexOf(")")
        val literalValue = GradleContext.getStringLiteralValue(value.substring(start + 1, end))
        return literalValue?.apply {
            if (startsWith(":")) {
                return substring(1, length)
            }
        }
    }

    private fun report(
            context: Context,
            cookie: Any,
            issue: Issue,
            message: String,
            fix: LintFix? = null
    ) {
        context.client.runReadAction(Runnable {
            if (context.isEnabled(issue) && context is GradleContext) {
                val checkComments =
                        context.containsCommentSuppress()
                if (checkComments && context.isSuppressedWithComment(cookie, issue)) {
                    return@Runnable
                }

                val location = context.getLocation(cookie)
                context.report(issue, location, message, fix)
            }
        })
    }
}