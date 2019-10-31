package com.acvoli.learning.algorithm.sorting;

import com.acvoli.learning.fun.FunPrint;

abstract class Sort<T extends Comparable<T>> {
  public abstract void sort(T[] nums);

  boolean less(T v, T w) {
    // compareTo返回的是int
    return v.compareTo(w) < 0;
  }

  void swap(T[] a, int i, int j) {
    T t = a[i];
    a[i] = a[j];
    a[j] = t;
    new FunPrint<T>().print(a);
  }
}
