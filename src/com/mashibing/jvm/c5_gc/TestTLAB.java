package com.mashibing.jvm.c5_gc;

public class TestTLAB {
    class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    void alloc(int i) {
        new User(i, "name " + i);
    }

    public static void main(String[] args) {
        // 默认打开了栈上分配和TLAB时间大概是260ms
        // 关闭逃逸分析、标量替换和线程专有分配后的时间480ms左右
        // -XX:-DoEscapeAnalysis -XX:-EliminateAllocations -XX:-UseTLAB
        TestTLAB t = new TestTLAB();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            t.alloc(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
