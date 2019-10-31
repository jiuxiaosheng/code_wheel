package com.acvoli.learning.design_mode.adapter;

class TurkeyAdapter implements Duck {
  private Turkey turkey;

  TurkeyAdapter(Turkey turkey) {
    this.turkey = turkey;
  }

  @Override
  public void quack() {
    // 这里真实调用的是turkey的gobble，达到让turkey拥有quack的能力
    turkey.gobble();
  }
}
