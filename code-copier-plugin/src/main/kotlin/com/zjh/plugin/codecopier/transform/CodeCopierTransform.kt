package com.zjh.plugin.codecopier.transform

import com.android.build.api.transform.QualifiedContent
import com.android.build.api.transform.Transform
import com.android.build.api.transform.TransformInvocation
import com.android.build.api.transform.TransformOutputProvider
import com.android.build.gradle.internal.pipeline.TransformManager
import kotlinx.coroutines.*

class CodeCopierTransform : Transform() {
    /**
     * 在Gradle任务中的插件名称
     */
    override fun getName() = "CodeCopier"

    /**
     * 输入类型
     */
    override fun getInputTypes(): MutableSet<QualifiedContent.ContentType> {
        //class文件
        return TransformManager.CONTENT_CLASS
    }

    /**
     * 作用范围
     */
    override fun getScopes(): MutableSet<in QualifiedContent.Scope> {
        //整个项目的所有模块
        return TransformManager.SCOPE_FULL_PROJECT
    }

    /**
     * 是否开启增量编译
     */
    override fun isIncremental(): Boolean {
        //不开增量编译，避免需要build的时候需要先cleanProject
        return false
    }

    /**
     * 关键: 在transform方法中，我们需要将每个jar包和class文件复制到dest路径，这个dest路径就是下一个Transform的输入数据。
     * 而在复制时，就可以将jar包和class文件的字节码做一些修改，再进行复制。
     */
    override fun transform(transformInvocation: TransformInvocation) {
        super.transform(transformInvocation)
        //是否是增量编译
        val isIncremental = transformInvocation.isIncremental

        //TransformOutputProvider管理输出路径,如果消费型输入为空,则outputProvider也为空
        val outputProvider = transformInvocation.outputProvider

        transformInvocation.inputs.forEach {
            //源码文件(即app模块)
            it.directoryInputs.forEach{ directoryInput ->
                val a = CoroutineScope(Dispatchers.Unconfined).async {

                }
            }

            //jar包（第三方的jar包，已经其他模块的代码生成的jar）
            it.jarInputs.forEach { jarInput ->

            }
        }

    }

    private fun processDirectoryInput(isIncremental: Boolean, outputProvider: TransformOutputProvider) {

    }

    private fun processJarInput() {

    }
}