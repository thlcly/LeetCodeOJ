package com.aaront.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author tonyhui
 * @since 2017/12/8
 */
public class Minesweeper {

    /**
     * 思路: 就是使用BFS, 根据下面的注释应该很好理解
     */
    public static void main(String[] args) {
        Minesweeper m = new Minesweeper();
        char[][] board = {{'E','E','E','E','E'},{'E','E','M','E','E'},{'E','E','E','E','E'},{'E','E','E','E','E'}};
        int[] click = new int[]{3, 0};
        m.updateBoard(board, click);
    }

    private static final int[][] order = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    private static final char REVEALED_MINE = 'X'; // 被点开的雷
    private static final char UNREVEALED_MINE = 'M'; // 没有被点开的雷
    private static final char REVEALED_BLANK_SQUARE = 'B'; // 被点开的空格
    private static final char UNREVEALED_BLANK_SQUARE = 'E'; // 没有被点开的空格

    public char[][] updateBoard(char[][] board, int[] click) {
        int row = board.length;
        int col = board[0].length;
        int x = click[0];
        int y = click[1];

        // 如果点开的是雷则直接返回
        if (board[x][y] == UNREVEALED_MINE) {
            board[x][y] = REVEALED_MINE;
            return board;
        }

        // 如果点击的是已经点开的空格则直接返回
        if (board[x][y] == REVEALED_BLANK_SQUARE) {
            return board;
        }

        update(x, y, row, col, board);

        return board;
    }

    public void update(int x, int y, int row, int col, char[][] board) {
        // 用于标记board中对应的点是否已经被访问过
        boolean[][] flag = new boolean[row][col];
        // 用于保存BFS中的数据
        Queue<Integer> points = new ArrayDeque<>();
        points.add(point2int(x, y, col));

        while(points.size() > 0) {
            Integer point = points.poll();
            int[][] arr = int2point(point, col);
            int tx = arr[0][0];
            int ty = arr[0][1];
            flag[tx][ty] = true;
            int mineNum = calcMineNum(tx, ty, row, col, board);
            if(mineNum != 0) {
                board[tx][ty] = (char)(mineNum + '0');
                continue;
            } else {
                board[tx][ty] = REVEALED_BLANK_SQUARE;
            }
            List<Integer> squares = findBlankSquare(tx, ty, row, col, board, flag);
            points.addAll(squares);
        }
    }

    public int calcMineNum(int x, int y, int row, int col, char[][]board) {
        int mineNum = 0;
        for(int i = 0;i<order.length;i++) {
            int tx = x + order[i][0];
            int ty = y + order[i][1];
            if(tx < 0 || tx >= row || ty < 0 || ty >= col) {
                continue;
            }
            if(board[tx][ty] == UNREVEALED_MINE) {
                mineNum++;
            }
        }
        return mineNum;
    }

    public List<Integer> findBlankSquare(int x, int y, int row, int col, char[][]board, boolean[][] flag) {
        List<Integer> points = new ArrayList<>();
        for(int i = 0;i<order.length;i++) {
            int tx = x + order[i][0];
            int ty = y + order[i][1];
            if(tx < 0 || tx >= row || ty < 0 || ty >= col || flag[tx][ty]) {
                continue;
            }
            flag[tx][ty] = true;
            int point = point2int(tx, ty, col);
            points.add(point);
        }

        return points;
    }


    public int point2int(int x, int y, int colLen) {
        return x * colLen + y;
    }

    public int[][] int2point(int i, int colLen) {
        int x = i / colLen;
        int y = i % colLen;
        return new int[][]{{x, y}};
    }
}
