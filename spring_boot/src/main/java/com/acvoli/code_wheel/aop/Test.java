package com.acvoli.code_wheel.aop;

public class Test {

    public static void main(String[] args) {
        int oldCapacity = 15;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        System.out.println(newCapacity);
    }
}
