package com.shivanshu.in.madeeasy.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * N-Queen Problem
 *
 * The n-queens puzzle is the problem of placing n queens on a (n×n) chessboard such that no two queens can attack each
 * other.Given an integer n, find all distinct solutions to the n-queens puzzle. Each solution contains distinct board
 * configurations of the n-queens’ placement, where the solutions are a permutation of [1,2,3..n] in increasing order,
 * here the number in the ith place denotes that the ith-column queen is placed in the row with that number.
 * For eg below figure represents a chessboard [3 1 4 2].
 *
 * Input:
 * 1
 * Output:
 * [1]
 *
 * Input:
 * 4
 * Output:
 * [2 4 1 3 ] [3 1 4 2 ]
 *
 * Input:
 * 5
 * Output:
 * [1 3 5 2 4 ] [1 4 2 5 3 ] [2 4 1 3 5 ] [2 5 3 1 4 ] [3 1 4 2 5 ] [3 5 2 4 1 ] [4 1 3 5 2 ] [4 2 5 3 1 ] [5 2 4 1 3 ] [5 3 1 4 2 ] 
 *
 */
public class NQueen {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            NQueenSolution ob = new NQueenSolution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if (ans.size() == 0)
                System.out.println("-1");
            else {
                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}

class NQueenSolution {
    private static ArrayList<ArrayList<Integer>> nqueens;

    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        nqueens = new ArrayList<>();
        for (int firstQRow = 1; firstQRow <= n; firstQRow++) {
           ArrayList<Integer> nqueen = new ArrayList<>();
            nqueen.add(firstQRow);
            findNextQueenPos(1, n, nqueen);
        }
        return nqueens;
    }

    private static void findNextQueenPos(int col, int n, ArrayList<Integer> nqueen) {
        if (col >= n ) {
            nqueens.add(new ArrayList<>(nqueen));
        }
        for (int nextRow = 1; nextRow <= n; nextRow++) {
            if (isSafe(nextRow, col, n, nqueen)) {
                nqueen.add(col,nextRow);
                findNextQueenPos(col + 1, n, nqueen);
                nqueen.remove(col);
            }
        }
    }

    private static boolean isSafe(int nextRow, int col, int n, ArrayList<Integer> nqueen) {
        if (nqueen.contains(nextRow)) {
            return false;
        }
        //System.out.println("Check Diagonally left UP");
        for (int i = nextRow, j = col; i > 1 && j > 0; i--, j--) {
            //System.out.println("Queen:"+(j-1)+" pos-"+nqueen.get(j - 1) + ", diagonal pos" + (i-1));
            if (nqueen.get(j - 1) == i-1) {
                return false;
            }
        }
        for (int i = nextRow, j = col; i <= n && j > 0; i++, j--) {
            if (nqueen.get(j - 1) == i + 1) {
                return false;
            }
        }
        return true;
    }
}
