package com.acvoli.learning.design_mode.strategy;

/**
 * 定义一系列算法，封装每个算法，并使它们可以互换。状态模式主要是用来解决状态转移的问题，当状态发生转移了，那么 Context
 * 对象就会改变它的行为；而策略模式主要是用来封装一组可以互相替代的算法族，并且可以根据需要动态地去替换 Context 使用的算法。
 */
class Client {
  public static void main(String[] args) {
    Duck duck = new Duck();
    duck.setQuackBehavior(new Squeak());
    duck.performQuack();

    // 在context中改变了策略（鸭叫声算法）
    duck.setQuackBehavior(new Quack());
    duck.performQuack();
  }
}
