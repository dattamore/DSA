package com.arrayMatrix.Ashhad;
import java.util.*;

//understanding https://www.youtube.com/watch?v=q2fl7lUkc8o
public class validSudoku {

	 public boolean isValidSudoku(char[][] board) {
	        int N = 9;
	        // Use hash set to record the status
	        HashSet<Character>[] rows = new HashSet[N];
	        HashSet<Character>[] cols = new HashSet[N];
	        HashSet<Character>[] boxes = new HashSet[N];
	        for (int r = 0; r < N; r++) {
	            rows[r] = new HashSet<Character>();
	            cols[r] = new HashSet<Character>();
	            boxes[r] = new HashSet<Character>();
	        }
	        for (int r = 0; r < N; r++) {
	            for (int c = 0; c < N; c++) {
	                char val = board[r][c];
	                // Check if the position is filled with number
	                if (val == '.') {
	                    continue;
	                }
	                // Check the row
	                if (rows[r].contains(val)) {
	                    return false;
	                }
	                rows[r].add(val);
	                // Check the column
	                if (cols[c].contains(val)) {
	                    return false;
	                }
	                cols[c].add(val);
	                // Check the box
	                int idx = (r / 3) * 3 + c / 3;
	                if (boxes[idx].contains(val)) {
	                    return false;
	                }
	                boxes[idx].add(val);
	            }
	        }
	        return true;
	    }
//chatgpt easier
    public boolean isValidSudokuGPT(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> rowSet = new HashSet<>();
            Set<Character> colSet = new HashSet<>();
            Set<Character> boxSet = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                // Check row
                if (board[i][j] != '.') {
                    if (!rowSet.add(board[i][j])) {
                        return false;
                    }
                }
                // Check column
                if (board[j][i] != '.') {
                    if (!colSet.add(board[j][i])) {
                        return false;
                    }
                }
                // Check 3x3 box
                int row = 3 * (i / 3) + j / 3;
                int col = 3 * (i % 3) + j % 3;

                if (board[row][col] != '.') {
                    if (!boxSet.add(board[row][col])) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    // Driver
    public static void main(String[] args) {
        validSudoku obj = new validSudoku();

        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        
        char[][] board2 = {
        		{'8','3','.','.','7','.','.','.','.'}
        		,{'6','.','.','1','9','5','.','.','.'}
        		,{'.','9','8','.','.','.','.','6','.'}
        		,{'8','.','.','.','6','.','.','.','3'}
        		,{'4','.','.','8','.','3','.','.','1'}
        		,{'7','.','.','.','2','.','.','.','6'}
        		,{'.','6','.','.','.','.','2','8','.'}
        		,{'.','.','.','4','1','9','.','.','5'}
        		,{'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println(obj.isValidSudokuGPT(board2)); // true
    }
}
