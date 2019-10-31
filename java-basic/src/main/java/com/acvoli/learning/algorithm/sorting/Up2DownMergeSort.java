package com.acvoli.learning.algorithm.sorting;

import com.acvoli.learning.fun.FunPrint;

class Up2DownMergeSort<T extends Comparable<T>> extends MergeSort<T> {
  @Override
  public void sort(T[] nums) {
    aux = (T[]) new Comparable[nums.length];
    // 一开始时输入整个数组
    sort(nums, 0, nums.length - 1);
  }

  private void sort(T[] nums, int L, int R) {
    // 递归退出条件，数组无法再分割了
    if (R <= L) {
      return;
    }
    // 获取输入数组的中间位置
    int mid = L + (R - L) / 2;
    // 递归对前半段数组进行排序
    sort(nums, L, mid);
    // 递归对后半段数据进行排序
    sort(nums, mid + 1, R);
    // 合并数组
    merge(nums, L, mid, R);
  }

  public static void main(String[] args) {
    Integer[] disorder = {10, 3, 200, 1, -1, 39, 98};
    new FunPrint<Integer>().print(disorder);
    Up2DownMergeSort<Integer> up2DownMergeSort = new Up2DownMergeSort<>();
    up2DownMergeSort.sort(disorder);
  }
}
