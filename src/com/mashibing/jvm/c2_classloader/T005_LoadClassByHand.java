package com.mashibing.jvm.c2_classloader;

public class T005_LoadClassByHand {
    public static void main(String[] args) throws ClassNotFoundException {
        // 什么时候需要自己加载类呢? 一个新class动态生成等
        Class clazz = T005_LoadClassByHand.class.getClassLoader().loadClass("com.mashibing.jvm.c2_classloader.T002_ClassLoaderLevel");
        System.out.println(clazz.getName());

        // 自定义类加载器 需要继承ClassLoader, 使用模板方法设计模式
    }
}
