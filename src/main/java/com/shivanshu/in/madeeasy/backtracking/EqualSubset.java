package com.shivanshu.in.madeeasy.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array arr[] of size N, check if it can be partitioned into two parts such that the sum of elements in both parts is the same.
 * <p>
 * Example 1
 * Input: N = 4
 * arr = {1, 5, 11, 5}
 * Output: YES
 * Explanation:
 * The two parts are {1, 5, 5} and {11}.
 */
public class EqualSubset {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for (int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);

            SubsetSolution ob = new SubsetSolution();
            int x = ob.equalPartition(N, arr);
            if (x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}

class SubsetSolution {
    static int equalPartition(int N, int arr[]) {
        double total = 0;
        for (int i = 0; i < N; i++) {
            total = total + arr[i];
        }
        double avg = total / 2;
        if (total % 2 == 0) {
            Arrays.sort(arr);
            for (int i = 0; i < N - 1; i++) {
                for(int j=i+1;j<N;j++) {
                    List<Integer> subset=new ArrayList<>();
                    subset.add(arr[i]);
                    if (isSubset(arr[i], j, avg, N,subset, arr)) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    static boolean isSubset(int subsetSum, int next, double avg, int N, List<Integer> subsetList, int arr[]) {
        if(subsetSum==avg){
            for(int num:subsetList){
                System.out.println(num);
            }
            return true;
        }else if(subsetSum>avg | next==N){
            return false;
        }
        subsetSum=subsetSum+arr[next];
        subsetList.add(arr[next]);
        return isSubset(subsetSum,next+1,avg,N,subsetList,arr);
    }
}