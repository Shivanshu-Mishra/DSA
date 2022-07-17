package com.shivanshu.in.madeeasy.backtracking;

import java.util.Scanner;

/**
 * Problem Statement:
 * Given a N*N board with the Knight placed on the first block of an empty board. Moving according to the rules of chess knight must visit each square exactly once. Print the order of each cell in which they are visited
 *
 * Algortihm
 * If all squares are visited
 *     print the solution
 * Else
 *    a) Add one of the next moves to solution vector and recursively
 *    check if this move leads to a solution. (A Knight can make maximum
 *    eight moves. We choose one of the 8 moves in this step).
 *    b) If the move chosen in the above step doesn't lead to a solution
 *    then remove this move from the solution vector and try other
 *    alternative moves.
 *    c) If none of the alternatives work then return false (Returning false
 *    will remove the previously added item in recursion and if false is
 *    returned by the initial call of recursion then "no solution exists" )
 */
public class KnightTour {
    private int[][] chessBoard;
    private int chessBoardSize;
    private int[] xMove = {2, 1, -1, -2, -2, -1, 1, 2};
    private int[] yMove = {1, 2, 2, 1, -1, -2, -2, -1};

    public KnightTour(int chessBoardSize) {
        this.chessBoardSize = chessBoardSize;
        chessBoard = new int[chessBoardSize][chessBoardSize];
        for (int row = 0; row < chessBoardSize; row++) {
            for (int col = 0; col < chessBoardSize; col++) {
                chessBoard[row][col] = -1;
            }
        }

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter n for nxn chess board");
        int chessBoardSize = Integer.parseInt(input.nextLine());
        KnightTour kt = new KnightTour(chessBoardSize);
        if(!kt.findMoves(0,0,1))
            System.out.println("Solution does not exist");
        kt.printBoard();
    }

    boolean isSafe(int x, int y) {
        return (x >= 0 && x < chessBoardSize && y >= 0 && y < chessBoardSize && chessBoard[x][y] == -1);
    }

    public void printBoard() {
        for (int row = 0; row < chessBoardSize; row++) {
            for (int col = 0; col < chessBoardSize; col++) {
                System.out.print(chessBoard[row][col] + " ");
            }
            System.out.println();
        }
    }

    public boolean findMoves(int x, int y, int movei) {
        int k, next_x, next_y;
        if (movei == chessBoardSize * chessBoardSize) {
            return true;
        }

        for (k = 0; k < 8; k++) {
            next_x = x + xMove[k];
            next_y = y + yMove[k];
            if (isSafe(next_x, next_y)) {
                chessBoard[next_x][next_y] = movei;
                System.out.println("Move "+movei+" at "+next_x+","+next_y);
                //movei++;
                if (findMoves(next_x, next_y,++movei )) {
                    return true;
                } else {
                    chessBoard[next_x][next_y] = -1;
                    movei--;
                }
            }
        }
        return false;
    }
}
