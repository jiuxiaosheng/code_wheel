package com.acvoli.learning.design_mode.factory_abstract;

class ConcreteFactory2 extends AbstractFactory {

  AbstractProductA createProductA() {
    return new ProductA2();
  }

  AbstractProductB createProductB() {
    return new ProductB2();
  }
}
