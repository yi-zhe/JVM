package com.mashibing.jvm.c2_classloader;

public class T003_ClassLoaderScope {
    public static void main(String[] args) {
        // sun.misc.Launcher源码
        String pathBoot = System.getProperty("sun.boot.class.path");
        // Unix/Linux/Mac需要用冒号
        System.out.println(pathBoot.replaceAll(":", System.lineSeparator()));

        System.out.println("-------------------------------");

        String pathExt = System.getProperty("java.ext.dirs");
        System.out.println(pathExt.replaceAll(":", System.lineSeparator()));

        System.out.println("-------------------------------");

        String pathApp = System.getProperty("java.class.path");
        System.out.println(pathApp.replaceAll(":", System.lineSeparator()));
    }
}
