package com.acvoli.learning.design_mode.factory_method;

class ConcreteFactory extends Factory {

  public Product factoryMethod() {
    return new ConcreteProduct();
  }
}
