package com.acvoli.learning.design_mode.decorator;

class Client {
  public static void main(String[] args) {
    Beverage beverage = new HouseBlend();

    // 添加（装饰）上Mocha
    beverage = new Mocha(beverage);

    // 添加（装饰）上Milk
    beverage = new Milk(beverage);
    System.out.println(beverage.cost());
  }
}
