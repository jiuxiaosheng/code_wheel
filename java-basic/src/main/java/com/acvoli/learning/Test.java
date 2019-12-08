package com.acvoli.learning;

import com.acvoli.learning.leetcode.tree.SimpleBinaryTree;
import com.acvoli.learning.leetcode.tree.SimpleBinaryTree.TreeNode;
import java.util.Stack;

public class Test {

    public static void main(String[] args) {
    }

    // 分层打印二叉树镜像


    // 分层打印二叉树
    public static void printTreeFloor(SimpleBinaryTree tree) {
        if (tree.getRoot() == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(tree.getRoot());
        int parentNum = 1;

        while (parentNum > 0) {
            parentNum = insertOneFloor(stack, parentNum);
        }
    }

    static int insertOneFloor(Stack<TreeNode> stack, int parentNum) {
        int nodeNum = 0;
        int size = stack.size();
        for (int i = parentNum; i > 0; i--) {
            TreeNode node = stack.get(size - i);
            nodeNum += insertIntoStack(stack, node);
        }
        return nodeNum;
    }


    static int insertIntoStack(Stack<TreeNode> stack, TreeNode node) {
        int nodeNum = 0;
        if (node.getLeftNode() != null) {
            stack.push(node.getLeftNode());
            nodeNum++;
        }
        if (node.getRightNode() != null) {
            stack.push(node.getRightNode());
            nodeNum++;
        }
        return nodeNum;
    }

    // 合并有序数组
    public static int[] merge(int[] arr1, int[] arr2) {
        int[] merge = new int[arr1.length + arr2.length];

        int i = 0;
        int j = 0;
        for (int m = 0; m < merge.length; m++) {
            if (i <= arr1.length - 1 && arr1[i] <= arr2[j]) {
                merge[m] = arr1[i++];
            } else {
                merge[m] = arr2[j++];
            }
        }
        return merge;
    }
}
