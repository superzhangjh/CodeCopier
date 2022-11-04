package com.zjh.plugin.codecopier.model

/**
 * 方法信息
 */
class MethodModel(
    val access: Int,
    val name: String,
    val descriptor: String,
    val signature: String?,
    val exceptions: Array<String>?
)