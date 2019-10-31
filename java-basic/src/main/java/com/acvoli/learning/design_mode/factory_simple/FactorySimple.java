package com.acvoli.learning.design_mode.factory_simple;

/** 简单工厂模式 在创建一个对象时不向客户（调用者）暴露内部细节，并提供一个创建对象的通用接口 好处： 客户类和具体子类的实现解耦 在增加了子类时，客户类原有代码不需要修改 */
class FactorySimple {
  public Product createProduct(int type) {
    if (type == 1) {
      return new ConcreteProduct1();
    } else if (type == 2) {
      return new ConcreteProduct2();
    }
    return new ConcreteProduct();
  }

  public static void main(String[] args) {
    FactorySimple factory = new FactorySimple();
    Product product = factory.createProduct(0);
    Product product1 = factory.createProduct(1);
    Product product2 = factory.createProduct(2);
  }
}
