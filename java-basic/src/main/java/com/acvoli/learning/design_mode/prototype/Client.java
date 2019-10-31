package com.acvoli.learning.design_mode.prototype;

/** 可以通过复制方法实现实例化一个对象 */
class Client {
  public static void main(String[] args) {
    Prototype prototype = new ConcretePrototype("abc");
    Prototype clone = prototype.myClone();
    System.out.println(clone.toString());
  }
}
