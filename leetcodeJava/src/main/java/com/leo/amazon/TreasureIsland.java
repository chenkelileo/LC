package com.leo.amazon;

import java.util.LinkedList;
import java.util.Queue;

public class TreasureIsland {
    static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static int minNumTreasureIsland(char[][] islands) {
        //corner
        if(islands == null || islands.length == 0 ||islands[0].length == 0) {
            return -1;
        }
        //init
        int m = islands.length;
        int n = islands[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int steps = 1;
        queue.add(new int[]{0, 0});
        islands[0][0] = 'D';
        // add all sources to queue and set 'visited'.
//        for(int i = 0; i < m; ++i){
//            for(int j = 0; j < n; ++j){
//                if(islands[i][j] == 'S'){
//                    queue.add(new int[]{i, j}); islands[i][j] = 'D';
//                }
//            }
//        }
        //iter
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i =0; i < size; i++) {
                int[] pos = queue.poll();
                for(int[] dir: dirs){
                    int x = pos[0] + dir[0];
                    int y = pos[1] + dir[1];
                    if(x < 0 || x >= m || y < 0 || y >= n || islands[x][y] =='D'){
                        continue;
                    }
                    if(islands[x][y] == 'X'){
                        return steps;
                    }
                    queue.add(new int[]{x,y});
                    islands[x][y] = 'D';
                }
            }
            steps++;
        }
        //return
        return -1;
    }
//    Time complexity: O(r * c).
//    Space complexity: O(r * c).

    public static void main(String[] args) {
        char[][] testcase = {{'O', 'O', 'O', 'O'},
                {'D', 'O', 'D', 'O'},
                {'O', 'O', 'O', 'O'},
                {'X', 'D', 'D', 'O'}};
        System.out.println(minNumTreasureIsland(testcase));
    }
}
