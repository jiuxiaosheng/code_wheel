package com.acvoli.learning.design_mode.prototype;

class ConcretePrototype extends Prototype {
  private String filed;

  ConcretePrototype(String filed) {
    this.filed = filed;
  }

  @Override
  Prototype myClone() {
    return new ConcretePrototype(filed);
  }

  @Override
  public String toString() {
    return filed;
  }
}
