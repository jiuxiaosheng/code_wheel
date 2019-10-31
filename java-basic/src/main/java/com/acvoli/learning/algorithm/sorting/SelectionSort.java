package com.acvoli.learning.algorithm.sorting;

import com.acvoli.learning.fun.FunPrint;

/**
 * 选择排序
 *
 * <p>选择排序需要 ~N2/2 次比较和 ~N 次交换，它的运行时间与输入无关
 *
 * @param <T>
 */
class SelectionSort<T extends Comparable<T>> extends Sort<T> {

  @Override
  public void sort(T[] nums) {
    int N = nums.length;
    for (int i = 0; i < N - 1; i++) {
      int min = i;
      // 找出与当前位置（i/min）还小的元素，然后进行交换
      // 每次都是从当前位置往后跑完整个数组
      // 每一次循环把最大的移到最后面
      for (int j = i + 1; j < N; j++) {
        if (less(nums[j], nums[min])) {
          min = j;
        }
      }
      swap(nums, i, min);
    }
  }

  public static void main(String[] args) {
    Integer[] disorder = {10, 3, 200, 1, -1, 39, 98};
    new FunPrint<Integer>().print(disorder);
    SelectionSort<Integer> selectionSort = new SelectionSort<>();
    selectionSort.sort(disorder);
  }
}
