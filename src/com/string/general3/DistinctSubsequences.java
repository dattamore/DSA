package com.string.general3;
//https://www.youtube.com/watch?v=A5IBp1ldlik
public class DistinctSubsequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numDistinct(String s, String t) {

        int m = s.length();
        int n = t.length();

        int[][] dp = new int[m + 1][n + 1];

        // base caseS
        dp[0][0] = 1;

       
        for (int i = 1; i <= m; i++) {          
                dp[i][0] = 1;          
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                char sc = s.charAt(i - 1);
                char pc = t.charAt(j - 1);

                if (pc == sc ) {
                    dp[i][j] = dp[i - 1][j - 1]+dp[i - 1][j];
                } 
                else  {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }
}
