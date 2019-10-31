package com.acvoli.learning.algorithm.sorting;

import com.acvoli.learning.fun.FunPrint;

class Down2UpMergeSort<T extends Comparable<T>> extends MergeSort<T> {

  @Override
  public void sort(T[] nums) {
    int N = nums.length;
    aux = (T[]) new Comparable[N];

    for (int sz = 1; sz < N; sz += sz) {
      for (int lo = 0; lo < N - sz; lo += sz + sz) {
        merge(nums, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
      }
    }
  }

  public static void main(String[] args) {
    Integer[] disorder = {10, 3, 200, 1, -1, 39, 98};
    new FunPrint<Integer>().print(disorder);
    Down2UpMergeSort<Integer> down2UpMergeSort = new Down2UpMergeSort<>();
    down2UpMergeSort.sort(disorder);
  }
}
