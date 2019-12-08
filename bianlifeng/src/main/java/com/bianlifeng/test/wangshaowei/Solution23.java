package com.bianlifeng.test.wangshaowei;

import java.util.ArrayList;
import java.util.List;

public class Solution23 {

    public class Node {

        public int val;
        public Node left;
        public Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    int step = 3;
    List<String> result = new ArrayList<>();

    /**
     * 只考虑IPV4的情况
     * <p>
     * 输入字符串限定条件 1：只包含数字
     */
    public List<String> restoreIpAddresses(String s) {
        if (s == null) {
            return result;
        }

        int l = s.length();
        // 因为IP格式为XXX.XXX.XXX.XXX，所以最长为12个字符，最少为4个字符
        if (l > 12 || l < 4) {
            return result;
        }

        // 每个IP段至少需要包含这么多个数字
        step = l / 4;
        insert(s, "", 0, 1);

        return result;
    }

    private void insert(String s, String pre, int pointer, int segment) {
        if (pointer > s.length() - 1) {
            return;
        }
        if (segment == 4) {
            String sub = s.substring(pointer);
            if (isLegalSegment(sub)) {
                pre += sub;
                System.out.println(pre);
                result.add(pre);
            }
        } else {
            // IP段长度只能是最小长度到3之间的范围
            for (int i = step; i <= 3 && pointer + i < s.length(); i++) {
                String sub = s.substring(pointer, pointer + i);
                if (isLegalSegment(sub)) {
                    String newPre = pre + sub + ",";
                    insert(s, newPre, pointer + i, segment + 1);
                }
            }
        }
    }

    private boolean isLegalSegment(String s) {
        return s.length() <= 3 && Integer.parseInt(s) <= 255;
    }


    public static void main(String[] args) {
        Solution23 solution23 = new Solution23();
        solution23.restoreIpAddresses("2552114161");
    }
}
