package com.mashibing.jvm.c2_classloader;

public class T001_ClassLoadingProcedure {
    public static void main(String[] args) {
        // 跟下面的顺序有关系
//        public static int count = 2;
//        public static T t = new T();
        System.out.println(T.count);
    }
}

class T {
    public static int count = 2;
    // 交换位置则为2
    public static T t = new T();

    // 成员变量 先申请内存赋默认值 执行构造方法赋初始值 两步
    private int m = 8;

    private T() {
        count++;
        System.out.println("--" + count);
    }
}
