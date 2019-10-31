package com.acvoli.learning.design_mode.iterator;

interface Iterator<Item> {
  Item next();

  boolean hasNext();
}
