package com.acvoli.learning.design_mode.strategy;

class Quack implements QuackBehavior {

  @Override
  public void quack() {
    System.out.println("quack!");
  }
}
