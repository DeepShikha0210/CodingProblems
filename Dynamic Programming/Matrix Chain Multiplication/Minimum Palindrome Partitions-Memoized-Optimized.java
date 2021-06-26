package CreatingSolutions;

import java.util.Arrays;
class Solution {

    static int[][] dp = new int[100][100];
    static int left=0, right = 0;

    static boolean isPalindrome(String string, int i, int j)
    {
        while(i < j)
        {
            if(string.charAt(i) != string.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    static int minPalPartition(String string, int i, int j) {
        if (i >= j || isPalindrome(string, i, j))
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        dp[i][j] = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {

            if (dp[i][k] != -1)
                left = dp[i][k];

            else
                left=minPalPartition(string, i, k);

            if (dp[k+1][j] != -1)
                right = dp[k+1][j];

            else
                right=minPalPartition(string, k+1, j);

            dp[i][j] = Math.min(dp[i][j], left+right + 1);
        }
        return dp[i][j];

    }

    // Driver code
    public static void main(String[] args)
    {
        String str = "ababbbabbababa";
        for (int[] row : dp)
            Arrays.fill(row, -1);
        System.out.println("Min cuts needed for " + "Palindrome Partitioning is " + minPalPartition(str, 0, str.length() - 1));
    }
}