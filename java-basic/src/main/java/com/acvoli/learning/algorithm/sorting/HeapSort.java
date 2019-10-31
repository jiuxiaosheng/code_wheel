package com.acvoli.learning.algorithm.sorting;

import com.acvoli.learning.fun.FunPrint;

/**
 * 堆排序
 *
 * <p>堆结构是一个完全二叉树
 *
 * @param <T>
 */
public class HeapSort<T extends Comparable<T>> extends Sort<T> {
  @Override
  public void sort(T[] nums) {
    int N = nums.length - 1;
    // 循环完成后，因为对所有父节点都进行了下沉，构建了堆（完全二叉树）
    for (int k = N / 2; k >= 1; k--) sink(nums, k, N);

    while (N > 1) {
      // 交换堆数组的第一个元素（根节点）和最后一个元素，让最大的元素排在数组最后
      swap(nums, 1, N--);
      // 对剩下的元素重新进行对结构创建
      sink(nums, 1, N);
    }
  }

  // 对K位置的元素进行下沉
  private void sink(T[] nums, int k, int N) {
    // 因为是对父节点进行下沉，所以需保证2 * k 小于等于数组长度
    while (2 * k <= N) {
      // 找到子节点
      int j = 2 * k;
      // 如果子节点存在并且该子节点比另一个子节点更小，则指针指向大的一个子节点，使父节点能与最大的一个子节点进行交换
      if (j < N && less(nums, j, j + 1)) j++;
      // 如果父节点不比当前指向的子节点小，则说明符合堆结构，退出本次循环
      if (!less(nums, k, j)) break;
      // 交换父节点和子节点
      swap(nums, k, j);
      // 指向父节点所在位置，继续循环让该节点进行下沉
      k = j;
    }
  }

  private boolean less(T[] nums, int i, int j) {
    return nums[i].compareTo(nums[j]) < 0;
  }

  public static void main(String[] args) {
    Integer[] disorder = {10, 3, 200, 1, -1, 39, 98};
    new FunPrint<Integer>().print(disorder);
    HeapSort<Integer> heapSort = new HeapSort<>();
    heapSort.sort(disorder);
  }
}
