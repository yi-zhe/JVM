package com.mashibing.jvm.c2_classloader;

import java.io.*;

public class T006_MSBClassLoader extends ClassLoader {
    public void m() {
        System.out.println("mmm");
    }

    // 自定义classLoader

    // 什么时候设置的parent ClassLoader?
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File f = new File("/Users/liuyang/projects/JVM/out/production/JVM/com/mashibing/jvm/c2_classloader", name.replaceAll(".", "/").concat(".class"));
        try {
            FileInputStream fis = new FileInputStream(f);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int b = 0;
            while ((b = fis.read()) != 0) {
                baos.write(b);
            }
            byte[] bytes = baos.toByteArray();
            baos.close();
            fis.close();
            return defineClass(name, bytes, 0, bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader l = new T006_MSBClassLoader();
        Class clazz = l.loadClass("com.mashibing.jvm.c2_classloader.T006_MSBClassLoader");
        T006_MSBClassLoader h = (T006_MSBClassLoader) clazz.newInstance();
        h.m();
        System.out.println(l.getClass().getClassLoader());
        System.out.println(l.getParent());
    }
}
