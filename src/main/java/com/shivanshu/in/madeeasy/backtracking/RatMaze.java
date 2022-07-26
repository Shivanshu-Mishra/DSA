package com.shivanshu.in.madeeasy.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class RatMaze {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }

}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    static ArrayList<String> res;
    static int[] rMoveX={1,-1,0,0};
    static int[] rMoveY={0,0,1,-1};
    static String directions="DURL";
    public static ArrayList<String> findPath(int[][] m, int n) {
        res=new ArrayList<String>();
        if(m[0][0] == 1){
            m[0][0]=2;
        }else{
            return res;
        }
        findRatPath(0,0,m,n,"");
        return res;
    }

    private static void findRatPath(int x,int y,int[][] m,int n,String path){
        if(x==n-1 && y==n-1){
            res.add(path);
            return;
        }
        for(int move=0;move<4;move++){
            int rNextMoveX=x+rMoveX[move];
            int rNextMoveY=y+rMoveY[move];
            if(isSafe(rNextMoveX,rNextMoveY,m,n)){
                m[rNextMoveX][rNextMoveY]=2;
                findRatPath(rNextMoveX,rNextMoveY,m,n,path+directions.charAt(move));
                m[rNextMoveX][rNextMoveY]=1;
            }

        }


    }

    private static boolean isSafe(int x,int y,int[][] m,int N){
        return (x>=0 && x<N && y>=0 && y<N && m[x][y]==1);
    }
}
