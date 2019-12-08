package com.bianlifeng.test.wangshaowei;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution32 {

    private static final String pa = "()";
    Set<String> set = new HashSet<>();


    private List<String> insert(int n) {
        insert("()", n);
        return new ArrayList<>(set);
    }

    private void insert(String s, int n) {
        if (n == 1) {
            set.add(s);
            return;
        }

        int length = s.length();
        for (int i = 0; i < length; i++) {
            String newStr;
            if (i == 0) {
                newStr = pa + s;
            } else {
                newStr = s.substring(0, i) + pa + s.substring(i);
            }
            insert(newStr, n - 1);
        }
    }

    private boolean isMirror(String s) {
        char[] chars = s.toCharArray();
        boolean r = true;
        for (int i = 0; i < s.length(); i += 2) {
            if (chars[i] != '(' || chars[i + 1] != ')') {
                r = false;
                break;
            }
        }
        return r;
    }


    public static void main(String[] args) {
        Solution32 solution32 = new Solution32();
        List<String> result = solution32.insert(3);
        for (String s : result) {
            System.out.println(s);
        }
    }
}
