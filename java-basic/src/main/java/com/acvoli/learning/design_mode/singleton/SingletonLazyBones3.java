package com.acvoli.learning.design_mode.singleton;

/** 懒汉单例模式 */
public class SingletonLazyBones3 {

  // 唯一的私有静态变量
  private static SingletonLazyBones3 instance;

  // 构造方法私有化
  private SingletonLazyBones3() {}

  // 在获取实例的方法进行同步，但会造成阻塞，不推荐使用
  public static synchronized SingletonLazyBones3 getInstance() {
    if (instance == null) {
      instance = new SingletonLazyBones3();
    }

    return instance;
  }
}
