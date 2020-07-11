package com.mashibing.jvm.c2_classloader;

public class T008_LazyLoading {

    // LazyInitializing
    // 必须初始化的条件
    // new getstatic putstatic invokestatic final除外
    // java.lang.reflect
    // 初始化子类时，父类必须初始化
    // 被执行的主类
    // 动态语言支持java.lang.invoke.MethodHandler解析结果为
    // REF_getstatic REF_putstatic REF_invokestatic

    public static void main(String[] args) throws ClassNotFoundException {
//        P p; // 不会加载
//        X x = new X(); // 子类父类都加载
//        System.out.println(P.i); // final 不加载
//        System.out.println(P.j); // 加载
//        Class.forName("com.mashibing.jvm.c2_classloader.T008_LazyLoading$P"); // 加载
    }

    public static class P {
        final static int i = 8;
        static int j = 9;
        static {
            System.out.println("P");
        }
    }

    public static class X extends P {
        static {
            System.out.println("X");
        }
    }
}
