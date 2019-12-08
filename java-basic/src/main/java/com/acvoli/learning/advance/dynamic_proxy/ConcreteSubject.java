package com.acvoli.learning.advance.dynamic_proxy;

/**
 * 真实主题，委托类
 */
public class ConcreteSubject implements Subject {

  @Override
  public void run() {
    System.out.println("ConcreteSubject run()");
  }
}
