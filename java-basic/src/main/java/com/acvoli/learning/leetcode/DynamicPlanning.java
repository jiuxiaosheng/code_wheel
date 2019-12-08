package com.acvoli.learning.leetcode;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DynamicPlanning {

    /**
     * 走到第 i 个楼梯的方法数为走到第 i-1 和第 i-2 个楼梯的方法数之和
     */
    private int climbingStairs(int stairs) {
        if (stairs <= 2) {
            return stairs;
        }

        // 持有前两阶楼梯的方法数，1阶和2阶的方法数直接初始化出来
        int pre1 = 1, pre2 = 2;
        for (int i = 2; i < stairs; i++) {
            // 当前阶梯的方法数
            int cur = pre1 + pre2;
            // 倒数第二阶交换为倒数第一阶
            pre2 = pre1;
            // 倒数第一阶交换为当前阶
            pre1 = cur;
        }
        return pre1;
    }

    private int rob(int[] nums) {
        int pre2 = 0, pre1 = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.max(pre2 + nums[i], pre1);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }

    private int dynamicPlanningLearning(int n) {
        int[] f = new int[n + 1];
        int cost;

        for (int i = 1; i <= n; i++) {
            cost = Integer.MAX_VALUE;
            if (i - 1 >= 0) {
                cost = Math.min(cost, f[i - 1] + 1);
            }
            if (i - 5 >= 0) {
                cost = Math.min(cost, f[i - 5] + 1);
            }
            if (i - 11 >= 0) {
                cost = Math.min(cost, f[i - 11] + 1);
            }
            f[i] = cost;
            System.out.printf("f[%d]=%d\n", i, f[i]);
        }
        return f[n];
    }

    public static void main(String[] args) throws InterruptedException {
        final int totalThread = 10;
        CountDownLatch countDownLatch = new CountDownLatch(totalThread);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < totalThread; i++) {
            executorService.execute(() -> {
                System.out.print("run..");
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        System.out.println("end");
        executorService.shutdown();

    }

    public static void before(Integer integer) {
        System.out.println("before");
        System.out.println(integer++);
        integer.notify();
    }

    public static void after(Integer integer) {
        try {
            integer.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(integer++);
        System.out.println("after");
    }
}
