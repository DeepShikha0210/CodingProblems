public class Solution {
    
     static int[][] L = new int[1000][1000]; 
     
    public int solve(String A, String B) {
        
        for(int[] row : L)
            Arrays.fill(row, -1);
        
        return LCS(A.toCharArray(), B.toCharArray(), A.length(), B.length());
    }
    
    public int LCS(char[] a, char[] b, int m, int n)
    {
        
        if(m==0 || n==0)
        return 0;
        
        if (L[m][n] != -1)
        return L[m][n];
        
        if(a[m-1] == b[n-1])
        L[m][n] = 1 + LCS(a, b, m-1, n-1);
         
        else
        L[m][n] = Math.max(LCS(a, b, m-1, n), LCS(a, b , m, n-1));
        
        return L[m][n];
        
    }
}