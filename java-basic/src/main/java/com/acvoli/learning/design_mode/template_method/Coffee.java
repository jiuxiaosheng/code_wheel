package com.acvoli.learning.design_mode.template_method;

class Coffee extends CaffeineBeverage {

  @Override
  void brew() {
    System.out.println("Coffee.brew");
  }

  @Override
  void addCondiments() {
    System.out.println("Coffee.addCondiments");
  }
}
