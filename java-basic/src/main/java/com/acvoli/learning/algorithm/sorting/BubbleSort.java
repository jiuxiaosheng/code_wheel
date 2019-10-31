package com.acvoli.learning.algorithm.sorting;

import com.acvoli.learning.fun.FunPrint;

/**
 * 冒泡排序
 *
 * @param <T>
 */
class BubbleSort<T extends Comparable<T>> extends Sort<T> {

  @Override
  public void sort(T[] nums) {
    int N = nums.length;
    boolean isSorted = false;
    for (int i = N - 1; i > 0 && !isSorted; i--) {
      // 冒泡排序的复杂度跟输入的数组本身排序情况有关，如果本身是排好序的，则只需要遍历一次且不需要任何swap
      isSorted = true;
      for (int j = 0; j < i; j++) {
        // 比较相领两个数字，把大的往后移（冒泡）
        if (less(nums[j + 1], nums[j])) {
          isSorted = false;
          swap(nums, j, j + 1);
        }
      }
    }
  }

  public static void main(String[] args) {
    Integer[] disorder = {10, 3, 200, 1, -1, 39, 98};
    new FunPrint<Integer>().print(disorder);
    BubbleSort<Integer> bubbleSort = new BubbleSort<>();
    bubbleSort.sort(disorder);
  }
}
