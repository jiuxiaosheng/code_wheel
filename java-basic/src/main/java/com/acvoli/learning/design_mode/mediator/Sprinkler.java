package com.acvoli.learning.design_mode.mediator;

class Sprinkler extends Colleague {

  @Override
  public void onEvent(Mediator mediator) {
    mediator.doEvent("sprinkler");
  }

  public void doSprinkler() {
    System.out.println("doSprinkler()");
  }
}
