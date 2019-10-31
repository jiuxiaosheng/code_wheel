package com.acvoli.learning.design_mode.adapter;

/** 把一个类接口转换成另一个用户需要的接口。 */
class Client {
  public static void main(String[] args) {
    Turkey turkey = new WildTurkey();
    Duck duck = new TurkeyAdapter(turkey);
    duck.quack();
  }
}
