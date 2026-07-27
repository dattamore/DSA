package com.graph.ashhad;


//https://www.youtube.com/watch?v=m9TrOL1ETxI
public class WordSearchOne {

	public static void main(String[] args) {
		WordSearchOne solution = new WordSearchOne();
//        char[][] board = {
//            {'A', 'B', 'C', 'E'},
//            {'S', 'F', 'C', 'S'},
//            {'A', 'D', 'E', 'E'}
//        };
//        String word = "ABCCED";
        
        char[][] board = {
        	    {'A', 'B', 'C'},
        	    {'D', 'E', 'F'},
        	    {'G', 'H', 'I'}
        	};
        	String word = "AEI"; // Output: false

        System.out.println(solution.exists(board, word)); // Output: true

	}
	boolean visited[][];
	public boolean exists(char[][] board,String word) {
	 int rows = board.length;
	 int columns = board[0].length;
	 
	 visited=new boolean[rows][columns];
	 
	 for (int i = 0; i < rows; i++) {
		for (int j = 0; j < columns; j++) {
			visited=new boolean[rows][columns];
			if(word.charAt(0) == board[i][j] &&
					searchWord(i,j,0,word,board)) {
				return true;
			}
		}
	}
	 
	 return false;
	}
	private boolean searchWord(int i, int j, int index, String word, char[][] board) {
		if(index == word.length()) {
			return true; 
		}
		if(i < 0 || j < 0 || i >=board.length || j >=board[0].length
				|| word.charAt(index)!=board[i][j] || visited[i][j]) {
			return false; 
		} 
		 visited[i][j] =true;
		 if(
				 searchWord(i+1,j,index+1,word,board) ||
				 searchWord(i-1,j,index+1,word,board) ||
				 searchWord(i,j+1,index+1,word,board) ||
				 searchWord(i,j-1,index+1,word,board) 
				 ) {
			 return true;
		 }
		// visited[i][j] =false; // line number 26 added to comment this.
		return false;
	}

}
