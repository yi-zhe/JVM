package com.mashibing.jvm.c3_jmm;

import com.mashibing.jvm.agent.ObjectSizeAgent;

public class T03_SizeOfObject {
    public static void main(String[] args) {
        System.out.println(ObjectSizeAgent.sizeOf(new Object()));
        System.out.println(ObjectSizeAgent.sizeOf(new int[]{}));
    }

    private static class P {
        // 8 mark word
        // 4 class pointer
        int id;         // 4
        String name;    // 4
        int age;        // 4
        byte b1;        // 1
        byte b2;        // 1

        Object o;       // 4
        byte b3;        // 1
    }
}
