package com.mashibing.jvm.c_04_RuntimeDataAreaAndInstructionSet;

public class TestPlusPlus {
    public static void main(String[] args) {
        int i = 8;
        // 操作数栈为8 把局部变量表的9又覆盖了
        i = i++;
//        i = ++i;
        System.out.println(i);
    }
}
