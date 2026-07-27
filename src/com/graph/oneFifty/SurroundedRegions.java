package com.graph.oneFifty;
import java.util.*;

import java.util.Arrays;

//https://www.youtube.com/watch?v=yyofzfxWeKk
//chatgpt
public class SurroundedRegions {

    public static void main(String[] args) {
        SurroundedRegions sr = new SurroundedRegions();
        char[][] board = {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };
        sr.solve(board);
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
        // Expected Output:
        // [X, X, X, X]
        // [X, X, X, X]
        // [X, X, X, X]
        // [X, O, X, X]
    }

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        // Step 1: Mark 'O's connected to the border as 'V'
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') floodFill(0, j, m, n, board);
            if (board[m - 1][j] == 'O') floodFill(m - 1, j, m, n, board);    
        }
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') floodFill(i, 0, m, n, board);
            if (board[i][n - 1] == 'O') floodFill(i, n - 1, m, n, board);
        }

        // Step 2: Flip all remaining 'O's to 'X' and all 'V's back to 'O'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'V') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void floodFill(int i, int j, int m, int n, char[][] board) {
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'V';  // Mark as visited
        floodFill(i + 1, j, m, n, board);
        floodFill(i - 1, j, m, n, board);
        floodFill(i, j + 1, m, n, board);
        floodFill(i, j - 1, m, n, board);
    }
}
