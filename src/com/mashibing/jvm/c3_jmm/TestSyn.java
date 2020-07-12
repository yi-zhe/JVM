package com.mashibing.jvm.c3_jmm;

public class TestSyn {
    synchronized void m() {
    }

    void n() {
        synchronized (this) {
        }
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
