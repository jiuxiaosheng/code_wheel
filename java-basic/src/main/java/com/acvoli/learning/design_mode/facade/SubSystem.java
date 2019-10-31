package com.acvoli.learning.design_mode.facade;

class SubSystem {
  void turnOnTV() {
    System.out.println("turnOnTV()");
  }

  void setCD(String cd) {
    System.out.println("setCD( " + cd + " )");
  }

  void startWatching() {
    System.out.println("startWatching()");
  }
}
