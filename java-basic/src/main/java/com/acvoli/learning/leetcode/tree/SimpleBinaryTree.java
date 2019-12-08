package com.acvoli.learning.leetcode.tree;


import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Stack;

public class SimpleBinaryTree {

    private TreeNode root = null;

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    // 查找, 二叉查找树才能这样用
    public TreeNode findNode(int value) {
        TreeNode current = root;
        while (true) {
            if (value == current.getValue()) {
                return current;
            } else if (value < current.getValue()) {
                current = current.getLeftNode();
            } else {
                current = current.getRightNode();
            }
            if (current == null) {
                return null;
            }
        }
    }

    // 插入
    public String insert(int value) {
        String result = "success";
        TreeNode node = new TreeNode(value);
        if (root == null) {
            root = node;
            root.setLeftNode(null);
            root.setRightNode(null);
        } else {
            TreeNode current = root;
            TreeNode parent = null;
            while (true) {
                if (value < current.getValue()) {
                    parent = current;
                    current = current.getLeftNode();
                    if (current == null) {
                        parent.setLeftNode(node);
                        break;
                    }
                } else if (value > current.getValue()) {
                    parent = current;
                    current = current.getRightNode();
                    if (current == null) {
                        parent.setRightNode(node);
                        break;
                    }
                } else {
                    result = "already having same value";
                }
            }
        }
        return result;
    }

    // 中序遍历递归操作,
    // 中序遍历左子树、访问根节点、中序遍历右子树。
    public void inOrderTraverse() {
        inOrderTraverse(root);
    }

    private void inOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraverse(node.getLeftNode());
        node.display();
        inOrderTraverse(node.getRightNode());
    }


    //中序遍历非递归操作
    public void inOrderByStack() {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.getLeftNode();
            }

            if (!stack.isEmpty()) {
                current = stack.pop();
                current.display();
                current = current.getRightNode();
            }
        }
    }

    //前序遍历，
    //先序遍历， 访问根节点、先序遍历左子树、先序遍历右子树。
    public void preOrderTraverse() {
        preOrderTraverse(root);
    }

    private void preOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }

        //打印表示遍历了该节点
        node.display();
        preOrderTraverse(node.getLeftNode());
        preOrderTraverse(node.getRightNode());
    }

    //前序遍历非递归操作
    public void preOrderByStack() {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                // 访问根节点
                current.display();
                // 把左节点押入栈中
                current = current.getLeftNode();
            }

            if (!stack.isEmpty()) {
                current = stack.pop();
                current = current.getRightNode();
            }
        }
    }

    // 后序遍历
    // 后序遍历：后续遍历左子树、后续遍历右子树、访问根节点。
    public void postOrderTraverse() {
        postOrderTraverse(root);
    }

    private void postOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraverse(node.getLeftNode());
        postOrderTraverse(node.getRightNode());
        node.display();
    }

    //后序遍历非递归操作
    public void postOrderByStack() {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        TreeNode preNode = null;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.getLeftNode();
            }

            if (!stack.isEmpty()) {
                current = stack.peek().getRightNode();
                if (current == null || current == preNode) {
                    current = stack.pop();
                    current.display();
                    preNode = current;
                    current = null;
                }
            }
        }
    }

    // 获取最大值
    public int getMaxValue() {
        return 0;
    }

    // 获取最小值
    public int getMinValue() {
        return 0;
    }

    // 删除
    public boolean delete(int value) {
        TreeNode current = root;
        TreeNode parent = null;
        boolean isLeftNode = true;

        while (true) {
            if (value == current.getValue()) {
                break;
            } else if (value < current.getValue()) {
                isLeftNode = true;
                parent = current;
                current = current.getLeftNode();
            } else {
                isLeftNode = false;
                parent = current;
                current = current.getRightNode();
            }
        }

        if (current == null) {
            return false;
        }

        // 需要删除的节点为叶子节点
        if (current.getLeftNode() == null && current.getRightNode() == null) {
            if (current == root) {
                root = null;
            } else if (parent != null) {
                if (isLeftNode) {
                    parent.setLeftNode(null);
                } else {
                    parent.setRightNode(null);
                }
            }
        }

        // 需要删除的节点有一个子节点，且该子节点为左子节点
        else if (current.getRightNode() == null) {
            if (current == root) {
                root = root.getLeftNode();
            } else if (parent != null) {
                //如果该节点是父节点的左子节点，将该节点的左子节点变为父节点的左子节点
                if (isLeftNode) {
                    parent.setLeftNode(current.getLeftNode());
                }
                //如果该节点是父节点的右子节点，将该节点的左子节点变为父节点的右子节点
                else {
                    parent.setRightNode(current.getLeftNode());
                }
            }
        }

        // 需要删除的节点有一个子节点，且该子节点为右子节点
        else if (current.getLeftNode() == null) {
            if (current == root) {
                root = current.getRightNode();
            } else if (parent != null) {
                //如果该节点是父节点的左子节点，将该节点的右子节点变为父节点的左子节点
                if (isLeftNode) {
                    parent.setLeftNode(current.getRightNode());
                }
                //如果该节点是父节点的右子节点，将该节点的右子节点变为父节点的右子节点
                else {
                    parent.setRightNode(current.getRightNode());
                }
            }
        }

        // 需要删除的节点有两个子节点，需要寻找该节点的后续节点替代删除节点
        else {
            TreeNode successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (parent != null) {
                //如果该节点是父节点的左子节点，将该节点的后继节点变为父节点的左子节点
                if (isLeftNode) {
                    parent.setLeftNode(successor);
                }
                //如果该节点是父节点的右子节点，将该节点的后继节点变为父节点的右子节点
                else {
                    parent.setRightNode(successor);
                }
            }
        }
        return true;
    }


    private TreeNode getSuccessor(TreeNode delNode) {
        TreeNode successor = delNode;
        TreeNode successorParent = null;
        TreeNode current = delNode.getRightNode();

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftNode();
        }

        // 如果后继节点不是删除节点的右子节点时
        if (successor != delNode.getRightNode() && successorParent != null) {

            //要将后继节点的右子节点指向后继结点父节点的左子节点，
            successorParent.setLeftNode(successor.getRightNode());

            //并将删除节点的右子节点指向后继结点的右子节点
            successor.setRightNode(delNode.getRightNode());
        }

        //任何情况下，都需要将删除节点的左子节点指向后继节点的左子节点
        successor.setLeftNode(delNode.getLeftNode());

        return successor;
    }

    public static class TreeNode {

        private TreeNode leftNode;
        private TreeNode rightNode;
        private int value;

        public TreeNode() {

        }

        public TreeNode(int value) {
            this.value = value;
        }

        // display做为遍历访问了该节点
        public void display() {
            System.out.print(value + "\t");
        }

        public TreeNode getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(TreeNode leftNode) {
            this.leftNode = leftNode;
        }

        public TreeNode getRightNode() {
            return rightNode;
        }

        public void setRightNode(TreeNode rightNode) {
            this.rightNode = rightNode;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
