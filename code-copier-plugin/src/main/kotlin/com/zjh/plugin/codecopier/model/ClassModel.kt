package com.zjh.plugin.codecopier.model

/**
 * 类信息
 */
class ClassModel(
    //版本
    val version: Int,

    //修饰符
    val access: Int,

    //类名 com/google/android/material/animation/MatrixEvaluator
    val name: String,

    //参数和返回值
    val signature: String?,

    val superName: String?,

    val interfaces: Array<String>?
) {
    //方法信息
    private var methods: MutableList<MethodModel>? = null

    /**
     * 添加方法信息
     */
    fun addMethod(method: MethodModel) {
        if (methods == null) {
            methods = mutableListOf()
        }
        methods?.add(method)
    }
}