package com.imooc.array;

import java.util.Arrays;

public class Array01 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] arr = new int[4][2];
        System.out.println(arr[0][0]);
    //    solution.findMinArrowShots(arr);
    }
}

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (p1, p2) -> p1[1] > p2[1] ? 1 : -1);
        int pos = points[0][1];
        int ans = 1;
        for (int[] balloon: points) {
            if (balloon[0] > pos) {
                pos = balloon[1];
                ++ans;
            }
        }
        return ans;
    }

}