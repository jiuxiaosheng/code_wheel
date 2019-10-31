package com.acvoli.learning.design_mode.strategy;

class Squeak implements QuackBehavior {

  @Override
  public void quack() {
    System.out.println("squeak!");
  }
}
