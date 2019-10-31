package com.acvoli.learning.design_mode.template_method;

abstract class CaffeineBeverage {

  /** 冲咖啡和冲茶流程相同，且被固定（final，子类无法重载 */
  final void prepareRecipe() {
    boilWater();
    brew();
    pourInCup();
    addCondiments();
  }

  /** 子类有自己的表现 */
  abstract void brew();

  /** 子类实现自己的行为 */
  abstract void addCondiments();

  /** 烧水为通用方法，子类无需再编写 */
  void boilWater() {
    System.out.println("boilWater");
  }

  /** 把水倒进杯子是通用方法，子类无需再编写 */
  void pourInCup() {
    System.out.println("pourInCup");
  }
}
