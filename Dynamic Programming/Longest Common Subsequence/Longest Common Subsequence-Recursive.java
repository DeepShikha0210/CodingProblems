package CreatingSolutions;
//RECURSIVE METHOD

public class Solution
{

    /* Returns length of LCS for X[0..m-1], Y[0..n-1] */
    static int lcs( char[] X, char[] Y, int m, int n )
    {
        if (m == 0 || n == 0)
            return 0;
        if (X[m-1] == Y[n-1])
            return 1 + lcs(X, Y, m-1, n-1);
        else
            return Math.max(lcs(X, Y, m, n-1), lcs(X, Y, m-1, n));
    }


    public static void main(String[] args)
    {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] X=s1.toCharArray();
        char[] Y=s2.toCharArray();
        int m = X.length;
        int n = Y.length;

        System.out.println("Length of LCS is" + " " + lcs( X, Y, m, n ) );
    }

}

/*
Time complexity of the above naive recursive approach is O(2^n)
in worst case and worst case happens when all characters of X and Y mismatch i.e., length of LCS is 0.

If we draw the complete recursion tree, then we can see that there are many subproblems which are solved
again and again. So this problem has Overlapping Substructure property and recomputation of same subproblems
can be avoided by either using Memoization or Tabulation.

*/