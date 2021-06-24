package CreatingSolutions;
//MEMOIZED METHOD - TOP-DOWN APPROACH

import java.util.Arrays;

public class Solution
{
    static int[][] L = new int[1000][1000];   // Can initiate according to constraints

    /* Returns length of LCS for X[0..m-1], Y[0..n-1] */
    static int lcs( char[] X, char[] Y, int m, int n )
    {
        if (m == 0 || n == 0)
            return 0;

        if( L[m][n] != -1)
            return L[m][n];

        if (X[m-1] == Y[n-1])
            return L[m][n] = 1 + lcs(X, Y, m-1, n-1);

        else
            return L[m][n] = Math.max(lcs(X, Y, m, n-1), lcs(X, Y, m-1, n));
    }


    public static void main(String[] args)
    {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] X=s1.toCharArray();
        char[] Y=s2.toCharArray();
        int m = X.length;
        int n = Y.length;

        for(int[] row : L)
            Arrays.fill(row, -1);

        System.out.println("Length of LCS is" + " " + lcs( X, Y, m, n ) );
    }

}