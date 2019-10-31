package com.acvoli.learning.design_mode.mediator;

/**
 * 中介者（Mediator）模式，适用于需要集中相关对象之间复杂的沟通和控制
 */
class Client {
  public static void main(String[] args) {
    Alarm alarm = new Alarm();
    CoffeePot coffeePot = new CoffeePot();
    Calender calender = new Calender();
    Sprinkler sprinkler = new Sprinkler();
    Mediator mediator = new ConcreteMediator(alarm, coffeePot, calender, sprinkler);
    // 闹钟事件到达，调用中介者就可以操作相关对象
    alarm.onEvent(mediator);
  }
}
