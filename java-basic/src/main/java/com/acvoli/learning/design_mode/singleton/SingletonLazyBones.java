package com.acvoli.learning.design_mode.singleton;

/** 懒汉单例模式 */
public class SingletonLazyBones {

  // 唯一的私有静态变量
  private static SingletonLazyBones instance;

  // 构造方法私有化
  private SingletonLazyBones() {}

  public static SingletonLazyBones getInstance() {

    // 此处线程不安全，在多个线程同时进入时，会实例话多次
    // 懒汉模式的好处是延长实例化，节约资源
    if (instance == null) {
      instance = new SingletonLazyBones();
    }

    return instance;
  }
}
