/*SEQUENCE PATTERN MATCHING*/
//can be done with O(n) complexity using two pointer approach

package CreatingSolutions;
// Dynamic Programming Java implementation


class Solution {

    // Returns length of length common
    // subsequence for str1[0..m-1],
    // str2[0..n-1]
    static int lcs(String str1, String str2, int m, int n)
    {
        int L[][] = new int[m + 1][n + 1];
        int i, j;

        // Following steps build L[m+1][n+1] in
        // bottom up fashion. Note that L[i][j]
        // contains length of LCS of str1[0..i-1]
        // and str2[0..j-1]
        for (i = 0; i <= m; i++) {
            for (j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;

                else if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    L[i][j] = L[i - 1][j - 1] + 1;

                else
                    L[i][j] = Math.max(L[i - 1][j],L[i][j - 1]);
            }
        }

        // L[m][n] contains length of LCS
        // for X[0..n-1] and Y[0..m-1]
        return L[m][n];
    }

  
    static boolean sequencePatternMatching(String str1,String str2)
    {
        int m = str1.length();
        int n = str2.length();
        int len = lcs(str1, str2, m, n);

        if(len == m)
            return true;

        return false;
    }

    // Driver code
    public static void main(String[] args)
    {
        String str1 = new String("AXY");
        String str2 = new String("ADXCPY");


        // Function Call
        System.out.println(sequencePatternMatching(str1, str2));
    }
}