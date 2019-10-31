package com.acvoli.learning.algorithm.sorting;

import com.acvoli.learning.fun.FunPrint;

/**
 * 对于大规模的数组，插入排序很慢，因为它只能交换相邻的元素，每次只能将逆序数量减少 1。希尔排序的出现就是为了解决插入排序的这种局限性，它通过交换不相邻的元素，每次可以将逆序数量减少大于 1。
 *
 * <p>希尔排序使用插入排序对间隔 h 的序列进行排序。通过不断减小 h，最后令 h=1，就可以使得整个数组是有序的。
 *
 * @param <T>
 */
class ShellSort<T extends Comparable<T>> extends Sort<T> {

  @Override
  public void sort(T[] nums) {
    int N = nums.length;
    int h = 1;

    while (h < N / 3) {
      h = h * 3 + 1;
    }

    while (h >= 1) {
      for (int i = h; i < N; i++) {
        for (int j = i; j >= h && less(nums[j], nums[j - h]); j -= h) {
          swap(nums, j, j - h);
        }
      }
      h = h / 3;
    }
  }

  public static void main(String[] args) {
    Integer[] disorder = {10, 3, 200, 1, -1, 39, 98};
    new FunPrint<Integer>().print(disorder);
    ShellSort<Integer> shellSort = new ShellSort<>();
    shellSort.sort(disorder);
  }
}
