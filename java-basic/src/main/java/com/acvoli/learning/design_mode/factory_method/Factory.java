package com.acvoli.learning.design_mode.factory_method;

/** 工厂方法 由各个工厂自己提供用来做处理的自己的实现实例 每个实际工厂只生产一个实现，这些实现实现相同的接口，保证所有实现的完整 */
abstract class Factory {
  public abstract Product factoryMethod();

  public void doSomething() {
    Product product = factoryMethod();
    // do something with product
  }

  public static void main(String[] args) {
    ConcreteFactory1 concreteFactory1 = new ConcreteFactory1();
    concreteFactory1.doSomething();

    ConcreteFactory2 concreteFactory2 = new ConcreteFactory2();
    concreteFactory1.doSomething();
  }
}
