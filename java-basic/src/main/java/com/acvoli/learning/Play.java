package com.acvoli.learning;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Play {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> test = Class.forName("com.acvoli.learning.Test");
        for (Method method : test.getMethods()) {
            System.out.println(method.toGenericString());
        }
    }
}
