package com.acvoli.learning.design_mode.visitor;

class Item implements Element {
  private String name;

  Item(String name) {
    this.name = name;
  }

  String getName() {
    return name;
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
