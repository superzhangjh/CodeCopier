package com.zjh.plugin.codecopier

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * 修改变成生成的class文件，并织入代码的插件
 */
class CodeCopierPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        println("插件应用成功")
    }
}