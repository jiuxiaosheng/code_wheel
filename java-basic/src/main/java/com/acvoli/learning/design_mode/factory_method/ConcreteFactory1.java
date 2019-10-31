package com.acvoli.learning.design_mode.factory_method;

class ConcreteFactory1 extends Factory {

  public Product factoryMethod() {
    return new ConcreteProduct1();
  }
}
