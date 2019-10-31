package com.acvoli.learning.algorithm.sorting;

import com.acvoli.learning.fun.FunPrint;

abstract class MergeSort<T extends Comparable<T>> extends Sort<T> {
  protected T[] aux;

  protected void merge(T[] nums, int L, int mid, int R) {
    System.out.printf("begin: %d, mid: %d, end: %d", L, mid, R);
    System.out.println();
    // i和j分别指向左部分开始和右部分开始
    int i = L, j = mid + 1;
    // 将数据复制到辅助数组
    for (int k = L; k <= R; k++) {
      aux[k] = nums[k];
    }

    // 循环次数是左部分+右部分的长度次数
    for (int k = L; k <= R; k++) {
      // 当左部分指针大于mid时，表示左部分的值已经全部放入，则只剩下右部分的值，则依次放入右部分值
      if (i > mid) {
        nums[k] = aux[j++];
      }
      // 当有部分指针大于最右边位置时，表示右部分已经全部放入，则只剩下左部分的值，则依次放入左部分的值
      else if (j > R) {
        nums[k] = aux[i++];
      }
      // 如果左部分的更小则放入左部分的值, 并把左部分指针往前推进一位
      else if (aux[i].compareTo(aux[j]) <= 0) {
        nums[k] = aux[i++];
      }
      // 上面的判断都没进入说明有部分更小，则放入右部分的值，并把有部分指针推进一位
      else {
        nums[k] = aux[j++];
      }
    }
    new FunPrint<T>().print(nums);
  }
}
