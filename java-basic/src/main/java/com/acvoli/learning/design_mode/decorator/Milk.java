package com.acvoli.learning.design_mode.decorator;

class Milk extends CondimentDecorator {

  Milk(Beverage beverage) {
    this.beverage = beverage;
  }

  @Override
  public double cost() {
    return 1 + beverage.cost();
  }
}
