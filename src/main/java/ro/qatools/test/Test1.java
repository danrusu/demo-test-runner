package ro.qatools.test;

import ro.qatools.base.Test;

public class Test1 {

    @Test
    public static void test1(){
        System.out.println("Test11");
        throw new RuntimeException("Test failure!");
    }

    @Test
    public void test2(){
        System.out.println("Test12");
    }

    public static void test3(){
        System.out.println("Test13");
    }
}
