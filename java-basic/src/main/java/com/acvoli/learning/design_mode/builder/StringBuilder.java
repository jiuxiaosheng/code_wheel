package com.acvoli.learning.design_mode.builder;

/** 封装对象构造过程，并允许按步骤构造 */
class StringBuilder extends AbstractStringBuilder {

  public StringBuilder() {
    super(16);
  }

  @Override
  public String toString() {
    return new String(value, 0, count);
  }
}
