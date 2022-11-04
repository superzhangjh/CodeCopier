package com.zjh.plugin.codecopier.visitor

import com.zjh.plugin.codecopier.ClassCache
import com.zjh.plugin.codecopier.Constants
import com.zjh.plugin.codecopier.model.ClassModel
import com.zjh.plugin.codecopier.model.MethodModel
import org.objectweb.asm.AnnotationVisitor
import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

/**
 * 统计类扫描器
 */
class StatisticsClassVisitor(classVisitor: ClassVisitor) : ClassVisitor(Constants.ASM_API, classVisitor) {
    private lateinit var classModel: ClassModel

    override fun visit(
        version: Int,
        access: Int,
        name: String,
        signature: String?,
        superName: String?,
        interfaces: Array<String>?
    ) {
        super.visit(version, access, name, signature, superName, interfaces)
        //创建类信息
        classModel = ClassModel(version, access, name, signature, superName, interfaces)
    }

    override fun visitMethod(
        access: Int,
        name: String,
        descriptor: String,
        signature: String?,
        exceptions: Array<String>?
    ): MethodVisitor {
        //添加扫描到到方法
        classModel.addMethod(MethodModel(access, name, descriptor, signature, exceptions))
        return super.visitMethod(access, name, descriptor, signature, exceptions)
    }

    override fun visitEnd() {
        super.visitEnd()
        //将扫描到的类添加到管理类中
        ClassCache.addClass(classModel)
    }

    override fun visitAnnotation(descriptor: String?, visible: Boolean): AnnotationVisitor {
        return super.visitAnnotation(descriptor, visible)
    }
}