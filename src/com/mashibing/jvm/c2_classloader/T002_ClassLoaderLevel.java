package com.mashibing.jvm.c2_classloader;

import sun.awt.HKSCS;
import sun.net.spi.nameservice.dns.DNSNameService;

public class T002_ClassLoaderLevel {
    public static void main(String[] args) {
        // Bootstrap 加载rt.jar等核心类 由C++实现, 是最顶层的类加载器
        System.out.println(String.class.getClassLoader());
        System.out.println(HKSCS.class.getClassLoader());

        // Extension 扩展类加载器 加载jre/lib/ext/*.jar 由-Djava.ext.dirs指定
        System.out.println(DNSNameService.class.getClassLoader());
        // App 类加载器 加载classpath指定的内容
        System.out.println(T002_ClassLoaderLevel.class.getClassLoader());

        System.out.println(DNSNameService.class.getClassLoader().getClass().getClassLoader());
        System.out.println(T002_ClassLoaderLevel.class.getClassLoader().getClass().getClassLoader());

        // Custom ClassLoader自定义类加载器

        // 双亲委派 -> 双向委派
        // 原因
        // 1. 安全性问题
        // 2. 不必重复加载

        System.out.println(ClassLoader.getSystemClassLoader());
    }
}
