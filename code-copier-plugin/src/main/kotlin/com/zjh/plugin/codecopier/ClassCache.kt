package com.zjh.plugin.codecopier

import com.zjh.plugin.codecopier.model.ClassModel

/**
 * 管理类
 */
object ClassCache {
    private val cache by lazy { mutableListOf<ClassModel>() }

    /**
     * 添加类的信息，将类名按文件夹分割开
     */
    fun addClass(clazz: ClassModel) {
        synchronized(cache) {
            cache.add(clazz)
        }
    }

    private fun putClassToDir(classDir: ClassDir, dirs: List<String>, index: Int, clazz: ClassModel) {
        val dir = dirs[index]
        //创建当前的文件夹
        if (classDir.children == null) {
            classDir.children = mutableMapOf()
        }
        if (index < dirs.lastIndex) { //表示当前不是最后一个路径

        } else { //表示最后一个路径，即类名
            classDir.put(dir, clazz)
        }

        if (classDir.children?.containsKey(dir) == true) {

        }
    }

    /**
     * 拆分目录
     * @param className 类名，格式 com/xxx/xxx
     */
    private fun splitDirs(className: String): List<String> {
        return className.split("/")
    }

    /**
     * 通过路径存储对应的class信息
     */
    class ClassDir (
        //类信息
        private val clazz: ClassModel? = null,

        //包含的子文件夹
        var children: MutableMap<String, ClassDir>? = null,
    ) {
        /**
         * 添加类信息
         */
        fun put(dir: String, clazz: ClassModel?) {
            if (children == null) {
                children = mutableMapOf()
            }
            children?.put(dir, ClassDir(clazz))
        }

        fun put(dir: String) {
            if (children == null) {
                children = mutableMapOf()
            }
        }
    }
}