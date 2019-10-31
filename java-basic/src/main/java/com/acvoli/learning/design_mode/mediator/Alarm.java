package com.acvoli.learning.design_mode.mediator;

class Alarm extends Colleague {

  @Override
  public void onEvent(Mediator mediator) {
    mediator.doEvent("alarm");
  }

  public void doAlarm() {
    System.out.println("doAlarm()");
  }
}
