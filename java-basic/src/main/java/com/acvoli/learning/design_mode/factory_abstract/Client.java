package com.acvoli.learning.design_mode.factory_abstract;

/** 抽象工厂 用于创建相关的家族对象 抽象工厂模式用到了工厂方法模式来创建单一对象 */
public class Client {
  public static void main(String[] args) {
    AbstractFactory abstractFactory = new ConcreteFactory1();
    // 需要同时创建这两个对象
    AbstractProductA productA = abstractFactory.createProductA();
    AbstractProductB productB = abstractFactory.createProductB();
  }
}
