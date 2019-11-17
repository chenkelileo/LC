package com.leo.jakeclass;

import java.util.LinkedList;
import java.util.Queue;

public class C8BfsNumOfIslands {
    final static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static int numIslands(char[][] grid) {
        //corner
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        //init
        int rowLen = grid.length;
        int colLen = grid[0].length;
        boolean[][] visited = new boolean[rowLen][colLen];
        int count = 0;
        //iter
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    bfs(grid, visited, i, j);
                    count++;
                }
            }
        }
        //return
        return count;
    }

    private static void bfs(char[][] grid, boolean[][] visited, int r, int c) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int rTemp = temp[0];
            int cTemp = temp[1];
            visited[rTemp][cTemp] = true;//don't forget
            for (int i = 0; i < dirs.length; i++) {
                int x = rTemp + dirs[i][0];//need init new var
                int y = cTemp + dirs[i][1];
                //System.out.println(x+" " +y);
                if ((x < rowLen && x >= 0) && (y < colLen && y >= 0) && grid[x][y] == '1' && !visited[x][y]) {
                    queue.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }

    }

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        System.out.println(numIslands(grid));
    }

}
