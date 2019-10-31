package com.acvoli.learning.design_mode.iterator;

/**
 * 迭代器（Iterator）模式提供一种顺序访问聚合对象元素的方法，并且不暴露聚合对象的内部表示
 */
public class Client {
  public static void main(String[] args) {
    Aggregate aggregate = new ConcreteAggregate();
    Iterator<Integer> iterator = aggregate.createIterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
}
