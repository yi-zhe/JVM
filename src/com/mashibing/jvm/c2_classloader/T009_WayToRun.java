package com.mashibing.jvm.c2_classloader;

public class T009_WayToRun {
    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            m();
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            m();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static void m() {
        for (int i = 0; i < 100000; i++) {
            int j = i % 3;
        }
    }
}
