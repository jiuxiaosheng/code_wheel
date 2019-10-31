package com.acvoli.learning.design_mode.singleton;

/** 懒汉单例模式 */
public class SingletonDoubleCheckLock {

  // 唯一的私有静态变量
  // 使用volatile禁止 JVM 的指令重排
  private static volatile SingletonDoubleCheckLock instance;

  // 构造方法私有化
  private SingletonDoubleCheckLock() {}

  // 双从校验锁
  public static synchronized SingletonDoubleCheckLock getInstance() {
    // 此处if避免多次实例化，同时避免缩小锁范围
    if (instance == null) {
      // 在实例为空的情况下进行同步
      synchronized (SingletonDoubleCheckLock.class) {
        // 此处需要再一次判断实例是否为空，避免在多个线程同时加锁的情况下先后执行实例化
        if (instance == null) {
          instance = new SingletonDoubleCheckLock();
        }
      }
    }

    return instance;
  }
}
