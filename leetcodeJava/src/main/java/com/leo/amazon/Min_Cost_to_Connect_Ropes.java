package com.leo.amazon;

import java.util.PriorityQueue;

public class Min_Cost_to_Connect_Ropes {
    public static int connect(int[] ropes) {
        //corner case
        if (ropes == null || ropes.length == 0) {
            return 0;
        }
//        if (ropes.length == 1) {
//            return ropes[0];
//        }
        //init
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int rope : ropes) {
            pq.offer(rope);
        }
        int res = 0;
        //iterator
        while (pq.size() != 1) {
            int temp = pq.poll() + pq.poll();
            pq.offer(temp);
            res += temp;
        }

        //return
        return res;
    }

    public static void main(String[] args) {
        int[] ropes = {20};
        int[] ropes2 = {1, 2, 5, 10, 35, 89};
        int[] ropes3 = {2, 2, 3, 3};
        System.out.println(connect(ropes));
        System.out.println(connect(ropes2));
        System.out.println(connect(ropes3));
    }

}
