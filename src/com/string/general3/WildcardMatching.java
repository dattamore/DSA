package com.string.general3;

//understanding : https://www.youtube.com/watch?v=7SHV_QfVROE
//code chatgpt
public class WildcardMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	    public boolean isMatch(String s, String p) {

	        int m = s.length();
	        int n = p.length();

	        boolean[][] dp = new boolean[m + 1][n + 1];

	        // base case
	        dp[0][0] = true;

	        // handle patterns like "*", "**", "***"
	        for (int j = 1; j <= n; j++) {
	            if (p.charAt(j - 1) == '*') {
	                dp[0][j] = dp[0][j - 1];
	            }
	        }

	        for (int i = 1; i <= m; i++) {
	            for (int j = 1; j <= n; j++) {

	                char sc = s.charAt(i - 1);
	                char pc = p.charAt(j - 1);

	                if (pc == sc || pc == '?') {
	                    dp[i][j] = dp[i - 1][j - 1];
	                } 
	                else if (pc == '*') {
	                    // '*' can match:
	                    // 1) empty → dp[i][j-1]
	                    // 2) one/more chars → dp[i-1][j]
	                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
	                }
	            }
	        }

	        return dp[m][n];
	    }
	
}
