package com.acvoli.learning.design_mode.composite;

abstract class Component {
  String name;

  Component(String name) {
    this.name = name;
  }

  void print() {
    print(0);
  }

  abstract void print(int level);

  public abstract void add(Component component);

  public abstract void remove(Component component);
}
