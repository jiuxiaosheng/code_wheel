package com.acvoli.learning.design_mode.factory_method;

class ConcreteFactory2 extends Factory {

  public Product factoryMethod() {
    return new ConcreteProduct2();
  }
}
