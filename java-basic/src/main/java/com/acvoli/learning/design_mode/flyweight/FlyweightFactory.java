package com.acvoli.learning.design_mode.flyweight;

import java.util.HashMap;

class FlyweightFactory {
  private HashMap<String, Flyweight> flyweights = new HashMap<>();

  Flyweight getFlyweight(String intrinsicState) {
    if (!flyweights.containsKey(intrinsicState)) {
      Flyweight flyweight = new ConcreteFlyweight(intrinsicState);
      flyweights.put(intrinsicState, flyweight);
    }
    return flyweights.get(intrinsicState);
  }
}
