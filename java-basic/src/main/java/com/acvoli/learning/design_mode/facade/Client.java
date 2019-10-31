package com.acvoli.learning.design_mode.facade;

/** 提供了一个统一的接口，用来访问子系统中的一群接口，从而让子系统更容易使用。 */
class Client {
  public static void main(String[] args) {
    Facade facade = new Facade();
    facade.watchMovie();
  }
}
