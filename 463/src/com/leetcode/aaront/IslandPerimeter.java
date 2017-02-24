package com.leetcode.aaront;

/**
 * @author tonyhui
 * @since 17/2/24
 */
public class IslandPerimeter {
    public static void main(String[] args) {
        IslandPerimeter islandPerimeter = new IslandPerimeter();
        System.out.println(islandPerimeter.islandPerimeter(new int[][]{
                {0, 1},
        }));
    }

    public int islandPerimeter(int[][] grid) {
        int length = grid.length + 2;
        int width = grid[0].length + 2;
        int[][] wrap = new int[length][width];
        for (int i = 0, len1 = grid.length; i < len1; i++) {
            for (int j = 0, len2 = grid[i].length; j < len2; j++) {
                wrap[i + 1][j + 1] = grid[i][j];
            }
        }
        int perimeter = 0;
        for (int i = 1, rows = length; i < rows; i++) {
            for (int j = 1, cols = width; j < cols; j++) {
                if (wrap[i][j] == 0 ||
                        wrap[i - 1][j] == 1 && wrap[i + 1][j] == 1 && wrap[i][j - 1] == 1 && wrap[i][j + 1] == 1) {
                    continue;
                }
                perimeter += (1 - wrap[i - 1][j]) + (1 - wrap[i + 1][j]) + (1 - wrap[i][j - 1]) + (1 - wrap[i][j + 1]);
            }
        }
        return perimeter;
    }

    /**
     * 两个矩形合并, 边数 = 2 * 4 - 2 * 1, 即会少2条边, 所以该题的本质就是计算总的island的个数 - 相邻的矩形的个数,
     * 为了不重复计算相邻的矩形的个数, 按右和下的顺序执行
     */
    public int betterMethod(int[][] grid) {
        int islands = 0, neighbours = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islands++; // count islands
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) neighbours++; // count down neighbours
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) neighbours++; // count right neighbours
                }
            }
        }

        return islands * 4 - neighbours * 2;
    }
}
