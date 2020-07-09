package com.mashibing.jvm.c2_classloader;

public class T004_ParentAndChild {
    public static void main(String[] args) {
        // App类加载器
        System.out.println(T004_ParentAndChild.class.getClassLoader());
        // App类加载器的类加载器是null说明由Bootstrap加载的
        System.out.println(T004_ParentAndChild.class.getClassLoader().getClass().getClassLoader());
        // 父加载器是Extension类加载器
        System.out.println(T004_ParentAndChild.class.getClassLoader().getParent());
        System.out.println(T004_ParentAndChild.class.getClassLoader().getParent().getParent());
    }
}
