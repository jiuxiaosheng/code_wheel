package com.acvoli.learning.leetcode.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test {

    private class Pair<Key, Value> {

        private Key key;
        private Value value;

        public Pair(Key key, Value value) {
            this.key = key;
            this.value = value;
        }

        public Key getKey() {
            return key;
        }

        public void setKey(Key key) {
            this.key = key;
        }

        public Value getValue() {
            return value;
        }

        public void setValue(Value value) {
            this.value = value;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grids) {
        //表示8个方向，对应在矩阵中做坐标的+-操作
        int[][] direction = {{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
        int m = grids.length, n = grids[0].length;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        // 从0，0位置开始出发
        queue.add(new Pair<>(0, 0));

        int pathLength = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            pathLength++;

            // 循环取出所有队列
            while (size-- > 0) {
                // 取出当前在的位置
                Pair<Integer, Integer> cur = queue.poll();
                int cr = cur.getKey(), cc = cur.getValue();

                // 标记当前位置为1，这样该位置就无法再走了
                grids[cr][cc] = 1;

                // 对8个方向进行循环判断
                for (int[] d : direction) {
                    // 分别表示往8个方向中走到其中一个时的坐标
                    int nr = cr + d[0], nc = cc + d[1];

                    // 如果超出矩阵范围或者不等于1，则表示该路径不通
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n || grids[nr][nc] == 1) {
                        continue;
                    }
                    // 如果已经走到了最右下角，则返回结果,这里最先到达的肯定是最短路径，因为按层循环的情况下，最先达到的就是最短的
                    if (nr == m - 1 && nc == n - 1) {
                        return pathLength + 1;
                    }

                    // 把能走通的位置加入到队列中
                    queue.add(new Pair<>(nr, nc));
                }
            }
        }
        return -1;
    }


    public int numSquares(int n) {
        List<Integer> squares = generateSquares(n);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] marked = new boolean[n + 1];

        queue.add(n);
        marked[n] = true;
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;

            while (size-- > 0) {

                int cur = queue.poll();

                for (int s : squares) {
                    int next = cur - s;
                    if (next < 0) {
                        break;
                    }
                    if (next == 0) {
                        return level;
                    }
                    if (marked[next]) {
                        continue;
                    }

                    marked[next] = true;
                    queue.add(next);
                }

            }
        }
        return n;
    }

    /**
     * 生成小于 n 的平方数序列
     * @return 1,4,9,...
     */
    private List<Integer> generateSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        int square = 1;
        int diff = 3;
        while (square <= n) {
            squares.add(square);
            square += diff;
            diff += 2;
        }
        return squares;
    }

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.numSquares(13));
    }
}
