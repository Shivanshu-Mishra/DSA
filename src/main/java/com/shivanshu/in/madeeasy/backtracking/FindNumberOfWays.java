package com.shivanshu.in.madeeasy.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * You are given a matrix having n rows and m columns. The special property of this matrix is that some of the cells of
 * this matrix are given as input, which are blocked i.e. they cannot be reached. Now you have to start from the cell
 * (1,1) and reach the end (n,m) provided during the journey you can move horizontally right from the current cell or
 * vertically down from the current cell. Can you answer the number of ways you can traverse the matrix obeying the
 * above constraints starting from (1,1) and ending at (n,m).
 * <p>
 * Input: n = 3, m = 3, k = 2,
 * blocked_cells = {{1,2},{3,2}}.
 * Output: 1
 * Explanation: There is only one path from
 * (1,1) to(3,3) which is (1,1)->(2,1)->(2,2)->
 * (2,3)->(3,3).
 * <p>
 * Input: n = 5, m = 5, k = 1,
 * blocked_cells = {{5,5}}
 * Output: 0
 * Explanation: There is no path to reach at
 * (5,5) beacuse (5,5) is blocked.
 * <p>
 * Expected Time Complexity: O(n*m)
 * Expected Space Complexity: O(n*m)
 */

public class FindNumberOfWays {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int k = Integer.parseInt(s[2]);
            int[][] blocked_cells = new int[k][2];
            for (int i = 0; i < k; i++) {
                String[] s1 = br.readLine().trim().split(" ");
                for (int j = 0; j < 2; j++) {
                    blocked_cells[i][j] = Integer.parseInt(s1[j]);
                }
            }
            Solution1 obj = new Solution1();
            int ans = obj.FindWays(n, m, blocked_cells);
            System.out.println(ans);

        }
    }
}

class Solution1 {
    int[] verticalMove = {1, 0};
    int[] horizontalMove = {0, 1};
    int numberOfWays = 0;

    private boolean isSafe(int x, int y, int n, int m, int[][] blocked_cells) {
        if (x < 1 | y < 1 | x > n | y > m) {
            return false;
        }
        for (int row = 0; row < blocked_cells.length; row++) {
            if (blocked_cells[row][0] == x && blocked_cells[row][1] == y) {
                return false;
            }
        }
        return true;
    }

    public int FindWays(int n, int m, int[][] blocked_cells) {
        findPath(1,1,n,m,blocked_cells);
        return numberOfWays;
    }

    private void findPath(int x,int y,int n, int m,int[][] blocked_cells){
        if(isSafe(x,y,n,m,blocked_cells)){
            if(x==n && y==m){
                numberOfWays++;
                return;
            }
            for(int k=0;k<2;k++){
                int next_x=x+verticalMove[k];
                int next_y=y+horizontalMove[k];
                findPath(next_x,next_y,n,m,blocked_cells);
            }
        }
    }
}
