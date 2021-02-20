package com.zxw.vm;

/**
 * @author: wuhongyun
 * @date: 2021/1/28
 */
public class JHSDB_TestCase {
    private static class ObjectHolder {
    }

    static class Test {
        static ObjectHolder staticObj = new ObjectHolder();
        ObjectHolder instanceObj = new ObjectHolder();

        void foo() {
            ObjectHolder localObj = new ObjectHolder();
            System.out.println("done");
        }
    }

    public static void main(String[] args) {
        Test test = new JHSDB_TestCase.Test();
        test.foo();
    }
}
