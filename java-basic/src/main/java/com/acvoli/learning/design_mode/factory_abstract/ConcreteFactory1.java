package com.acvoli.learning.design_mode.factory_abstract;

class ConcreteFactory1 extends AbstractFactory {

  AbstractProductA createProductA() {
    return new ProductA1();
  }

  AbstractProductB createProductB() {
    return new ProductB1();
  }
}
