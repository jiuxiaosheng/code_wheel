package com.acvoli.learning.design_mode.singleton;

/** 懒汉单例模式 */
public class SingletonLazyBones2 {

  private static SingletonLazyBones2 instance = new SingletonLazyBones2();

  private SingletonLazyBones2() {}

  public static SingletonLazyBones2 getInstance() {
    return instance;
  }
}
