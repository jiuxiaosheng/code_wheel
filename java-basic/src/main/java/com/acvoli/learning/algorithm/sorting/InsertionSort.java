package com.acvoli.learning.algorithm.sorting;

import com.acvoli.learning.fun.FunPrint;

/**
 * 插入排序
 *
 * <p>对于数组 {3, 5, 2, 4, 1}，
 *
 * <p>它具有以下逆序：(3, 2), (3, 1), (5, 2), (5, 4), (5, 1), (2, 1), (4,1)，
 *
 * <p>插入排序每次只能交换相邻元素，令逆序数量减少 1，因此插入排序需要交换的次数为逆序数量。
 *
 * <p>平均情况下插入排序需要 ~N2/4 比较以及 ~N2/4 次交换；
 *
 * <p>最坏的情况下需要 ~N2/2 比较以及 ~N2/2 次交换，最坏的情况是数组是倒序的；
 *
 * <p>最好的情况下需要 N-1次比较和 0 次交换，最好的情况就是数组已经有序了。
 *
 * @param <T>
 */
class InsertionSort<T extends Comparable<T>> extends Sort<T> {

  @Override
  public void sort(T[] nums) {
    int N = nums.length;
    for (int i = 1; i < N; i++) {
      // 每次都将当前元素插入到左侧已经排序的数组中，使得插入之后左侧数组依然有序。
      for (int j = i; j > 0 && less(nums[j], nums[j - 1]); j--) {
        swap(nums, j, j - 1);
      }
    }
  }

  public static void main(String[] args) {
    Integer[] disorder = {10, 3, 200, 1, -1, 39, 98};
    new FunPrint<Integer>().print(disorder);
    InsertionSort<Integer> insertionSort = new InsertionSort<>();
    insertionSort.sort(disorder);
  }
}
