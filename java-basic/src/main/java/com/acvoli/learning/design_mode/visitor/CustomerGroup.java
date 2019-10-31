package com.acvoli.learning.design_mode.visitor;

import java.util.ArrayList;
import java.util.List;

class CustomerGroup {
  private List<Customer> customers = new ArrayList<>();

  void accept(Visitor visitor) {
    for (Customer customer : customers) {
      customer.accept(visitor);
    }
  }

  void addCustomer(Customer customer) {
    customers.add(customer);
  }
}
