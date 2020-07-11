package com.mashibing.jvm.c2_classloader;

import java.io.*;

public class T012_ClassReloading2 {

    private static class MyLoader extends ClassLoader {

        @Override
        public Class<?> loadClass(String name) throws ClassNotFoundException {

            File f = new File("/Users/liuyang/projects/JVM/out/production/JVM/com/mashibing/jvm/c2_classloader", name.replaceAll(".", "/").concat(".class"));
            if(!f.exists()) return super.loadClass(name);

            try {

                InputStream is = new FileInputStream(f);

                byte[] b = new byte[is.available()];
                is.read(b);
                return defineClass(name, b, 0, b.length);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return super.loadClass(name);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        MyLoader m = new MyLoader();
        Class clazz = m.loadClass("com.mashibing.jvm.c2_classloader.T004_ParentAndChild");

        m = new MyLoader();
        Class clazzNew = m.loadClass("com.mashibing.jvm.c2_classloader.T004_ParentAndChild");
        System.out.println(clazz == clazzNew); // 仍然相等 有点问题啊
    }
}
