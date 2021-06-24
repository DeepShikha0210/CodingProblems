package CreatingSolutions;
class  Solution
{
    // Returns length of LCS for X[0..m-1], Y[0..n-1]
    static String lcs(String X, String Y, int m, int n)
    {
        int[][] L = new int[m+1][n+1];

        // Following steps build L[m+1][n+1] in bottom up fashion. Note
        // that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1]
        for (int i=0; i<=m; i++)
        {
            for (int j=0; j<=n; j++)
            {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X.charAt(i-1) == Y.charAt(j-1))
                    L[i][j] = L[i-1][j-1] + 1;
                else
                    L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
            }
        }

        // Following code is used to print LCS

        // Start from the right-most-bottom-most corner and
        // one by one store characters in lcs[]
        int i = m;
        int j = n;
        StringBuilder result = new StringBuilder();
        while (i > 0 && j > 0)
        {
            // If current character in X[] and Y are same, then
            // current character is part of LCS
            if (X.charAt(i-1) == Y.charAt(j-1))
            {
                // Put current character in result
                result.append(X.charAt(i-1));
                // reduce values of i, j and index
                i--;
                j--;
            }

            // If not same, then find the larger of two and
            // go in the direction of larger value
            else if (L[i-1][j] > L[i][j-1])
                i--;
            else
                j--;
        }

        return result.reverse().toString();
    }

    // driver program
    public static void main (String[] args)
    {
        String X = "AGGTAB";
        String Y = "GXTXAYB";
        int m = X.length();
        int n = Y.length();
        System.out.println(lcs(X, Y, m, n));
    }
}