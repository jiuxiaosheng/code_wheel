package com.acvoli.learning.design_mode.template_method;

class Tea extends CaffeineBeverage {

  @Override
  void brew() {
    System.out.println("Tea.brew");
  }

  @Override
  void addCondiments() {
    System.out.println("Tea.addCondiments");
  }
}
