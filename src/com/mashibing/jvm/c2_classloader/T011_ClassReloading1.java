package com.mashibing.jvm.c2_classloader;

public class T011_ClassReloading1 {
    public static void main(String[] args) throws ClassNotFoundException {
        T006_MSBClassLoader msbClassLoader = new T006_MSBClassLoader();
        Class clazz = msbClassLoader.loadClass("com.mashibing.jvm.c2_classloader.T011_ClassReloading1");

        msbClassLoader = null;
        System.out.println(clazz.hashCode());

        msbClassLoader = null;

        msbClassLoader = new T006_MSBClassLoader();
        Class clazz1 = msbClassLoader.loadClass("com.mashibing.jvm.c2_classloader.T011_ClassReloading1");
        System.out.println(clazz1.hashCode());

        System.out.println(clazz == clazz1);
    }
}
