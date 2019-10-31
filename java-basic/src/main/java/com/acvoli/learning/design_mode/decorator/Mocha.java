package com.acvoli.learning.design_mode.decorator;

class Mocha extends CondimentDecorator {
  Mocha(Beverage beverage) {
    this.beverage = beverage;
  }

  @Override
  public double cost() {
    return 1 + beverage.cost();
  }
}
