package com.acvoli.learning.design_mode.singleton;

/** 懒汉单例模式 利用静态内部类持有实例的方式 该方式兼具延迟加载和线程安全的好处 */
public class SingletonStaticInnerClass {

  private SingletonStaticInnerClass() {}

  private static class SingleHolder {

    private static final SingletonStaticInnerClass INSTANCE = new SingletonStaticInnerClass();
  }

  public static SingletonStaticInnerClass getInstance() {
    return SingleHolder.INSTANCE;
  }
}
