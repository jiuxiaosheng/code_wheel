package com.acvoli.learning.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class BST<Key extends Comparable<Key>, Value> implements OrderedST<Key, Value> {


    protected Node root;


    protected class Node {

        Key key;
        Value val;
        Node left;
        Node right;
        // 以该节点为根的子树节点总数
        int N;
        // 红黑树中使用
        boolean color;

        Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        }
        return x.N;
    }

    protected void recalculateSize(Node x) {
        x.N = size(x.left) + size(x.right) + 1;
    }

    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value) {
        if (x == null) {
            x = new Node(key, value, 1);
        }

        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            x.val = value;
        } else if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else {
            x.right = put(x.right, key, value);
        }
        recalculateSize(x);
        return x;
    }

    @Override
    public Value get(Key key) {
        return get(root, key);
    }

    /**
     * 小于等于键的最大键 如果键小于根节点的键，那么 floor(key) 一定在左子树中 如果键大于根节点的键，需要先判断右子树中是否存在
     * floor(key)，如果存在就返回，否则根节点就是 floor(key)
     */
    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        }
        return x.key;
    }

    public Node floor(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        } else if (cmp < 0) {
            return floor(x.left, key);
        }

        Node t = floor(x.right, key);
        return t != null ? t : x;
    }

    private Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x.val;
        } else if (cmp < 0) {
            return get(x.left, key);
        } else {
            return get(x.right, key);
        }
    }

    @Override
    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x == null) {
            return null;
        }
        if (x.left != null) {
            return min(x.left);
        } else {
            return x;
        }
    }

    @Override
    public Key max() {
        return null;
    }

    void deleteMin() {
        root = deleteMin(root);
    }

    Node deleteMin(Node x) {
        if (x.left == null) {
            return x.right;
        }

        x.left = deleteMin(x.left);
        recalculateSize(x);
        return x;
    }

    void delete(Key key) {
        root = delete(root, key);
    }

    Node delete(Node x, Key key) {

        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return delete(x.left, key);
        } else if (cmp > 0) {
            return delete(x.right, key);
        } else {
            if (x.right == null) {
                return x.left;
            }
            if (x.left == null) {
                return x.right;
            }
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        recalculateSize(x);
        return x;
    }

    @Override
    public int rank(Key key) {
        return rank(root, key);
    }

    public int rank(Node x, Key key) {
        if (x == null) {
            return 1;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return size(x.left);
        } else if (cmp < 0) {
            return rank(x.left, key);
        } else {
            return size(x.left) + 1 + rank(x.right, key);
        }
    }

    @Override
    public List<Key> keys(Key l, Key h) {
        if (l.compareTo(h) > 0) {
            Key tmp = l;
            l = h;
            h = tmp;
        }
        return keys(root, l, h);
    }

    private List<Key> keys(Node x, Key l, Key h) {
        List<Key> list = new ArrayList<>();
        if (x == null) {
            return list;
        }
        int cmpL = l.compareTo(x.key);
        int cmpH = h.compareTo(x.key);

        // 利用二叉查找树中序遍历的结果为递增的特点
        if (cmpL < 0) {
            list.addAll(keys(x.left, l, h));
        }
        if (cmpL <= 0 && cmpH >= 0) {
            list.add(x.key);
        }
        if (cmpH > 0) {
            list.addAll(keys(x.right, l, h));
        }
        return list;
    }
}
