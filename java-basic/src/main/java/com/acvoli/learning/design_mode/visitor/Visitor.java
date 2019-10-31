package com.acvoli.learning.design_mode.visitor;

interface Visitor {
  void visit(Customer customer);

  void visit(Order order);

  void visit(Item item);
}
