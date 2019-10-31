package com.acvoli.learning.design_mode.bridge;

/** 将抽象与实现分离开来，使它们可以独立变化。 每个控制器可以有自己的实现，同时可以控制电视 */
class Client {
  public static void main(String[] args) {
    // 第一个控制器可以控制RCA TV
    RemoteControl remoteControl1 = new ConcreteRemoteControl1(new RCA());
    remoteControl1.on();
    remoteControl1.off();
    remoteControl1.tuneChannel();

    // 第二个控制器可以控制Sony TV
    RemoteControl remoteControl2 = new ConcreteRemoteControl2(new Sony());
    remoteControl2.on();
    remoteControl2.off();
    remoteControl2.tuneChannel();
  }
}
