package com.acvoli.learning.design_mode.strategy;

class Duck {
  private QuackBehavior quackBehavior;

  /** 发出鸭叫 */
  public void performQuack() {
    if (quackBehavior != null) {
      quackBehavior.quack();
    }
  }

  /**
   * 改变鸭叫声表现（算法）
   *
   * @param quackBehavior 鸭叫声表现（算法）
   */
  public void setQuackBehavior(QuackBehavior quackBehavior) {
    this.quackBehavior = quackBehavior;
  }
}
