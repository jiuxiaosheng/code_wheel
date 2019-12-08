package com.acvoli.learning.leetcode.tree;

public class RedBlackTree<Key extends Comparable<Key>, Value> extends BST<Key, Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }

    public Node rotateLeft(Node h) {
        // 获取需要左旋节点的右节点，即红节点
        Node x = h.right;
        // 讲中间大小的节点访问h的有节点
        h.right = x.left;
        x.left = h;
        // 交换颜色
        x.color = h.color;
        h.color = RED;
        //交换子树节点数
        x.N = h.N;
        recalculateSize(h);
        return x;
    }

    public Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        recalculateSize(h);
        return x;
    }

    void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
        root.color = BLACK;
    }

    private Node put(Node x, Key key, Value value) {
        if (x == null) {
            Node node = new Node(key, value, 1);
            // 初始化颜色为红色
            node.color = RED;
            return node;
        }

        // 按照BST的方式插入节点
        int cmp = key.compareTo(x.key);
        if (cmp == 0)
            x.val = value;
        else if (cmp < 0)
            x.left = put(x.left, key, value);
        else
            x.right = put(x.right, key, value);

        if (isRed(x.right) && !isRed(x.left))
            x = rotateLeft(x);
        if (isRed(x.left) && isRed(x.left.left))
            x = rotateRight(x);
        if (isRed(x.left) && isRed(x.right))
            flipColors(x);

        recalculateSize(x);
        return x;
    }
}
