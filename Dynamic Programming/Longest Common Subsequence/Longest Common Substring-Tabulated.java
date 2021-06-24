//TABULATED METHOD- Bottom-Up Approach

/*Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.
Examples:

Input : X = “Deepshikha”, y = “shikha”
Output : 6
The longest common substring is “shikha” and is of length 6.*/

//  Java implementation of
// finding length of longest
// Common substring using
// Dynamic Programming
package CreatingSolutions;

class Solution {
    /*
       Returns length of longest common substring
       of X[0..m-1] and Y[0..n-1]
    */
    static int LCSubstring(char X[], char Y[], int m, int n)
    {
       /* Create a table to store lengths of longest common suffixes of substrings.Note that LCS[i][j]
	   contains length of longest common suffix of X[0..i-1] and Y[0..j-1]. The first row and first column 
	   entries have n logical meaning, they are used only for simplicity of program*/
	   
        int[][] LCS = new int[m + 1][n + 1];

        // To store length of the longest common substring
        int result = 0;

        // Following steps build
        // LCS[m+1][n+1] in bottom up way
        for (int i = 0; i <= m; i++)
        {
            for (int j = 0; j <= n; j++)
            {
                if (i == 0 || j == 0)
                    LCS[i][j] = 0;
                else if (X[i - 1] == Y[j - 1])
                {
                    LCS[i][j] = LCS[i - 1][j - 1] + 1;
                    result = Integer.max(result, LCS[i][j]);
                }
                else
                    LCS[i][j] = 0;
            }
        }
        return result;
    }

    // Driver Code
    public static void main(String[] args)
    {
        String X = "Deepshikha";
        String Y = "shikha";

        int m = X.length();
        int n = Y.length();

        System.out.println(LCSubstring(X.toCharArray(), Y.toCharArray(), m, n));
    }
}


/*
Time Complexity: O(m*n) 
Auxiliary Space: O(m*n)

Another approach: (Space optimized approach).
In the above approach we are only using the last row of the 2-D array only, hence we can optimize 
the space by using  a 2-D array of dimension 2*(min(n,m)).
*/