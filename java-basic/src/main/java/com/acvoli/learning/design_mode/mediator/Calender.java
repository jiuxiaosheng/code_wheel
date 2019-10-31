package com.acvoli.learning.design_mode.mediator;

class Calender extends Colleague {

  @Override
  public void onEvent(Mediator mediator) {
    mediator.doEvent("calender");
  }

  public void doCalender() {
    System.out.println("doCalender()");
  }
}
