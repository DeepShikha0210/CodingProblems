/*BOTTOM-UP APPROACH
1) The base condition changes into initialisation step
2) Replace n and W i.e. the varying ones in the recursive step to i and j respectively.

For example:

//max((val[n - 1] + knapSackRec(W - wt[n - 1], wt, val, n - 1, dp)), knapSackRec(W, wt, val, n - 1, dp)); 

//max(val[i - 1] + K[i - 1][j - wt[i - 1]],  K[i - 1][j]);


*/
// A Dynamic Programming based solution
// for 0-1 Knapsack problem
class Knapsack {                                    //BOTTOM-UP APPROACH
 
    // A utility function that returns
    // maximum of two integers
    static int max(int a, int b)
    {
          return (a > b) ? a : b;
    }
 
    // Returns the maximum value that can
    // be put in a knapsack of capacity W
    static int knapSack(int W, int wt[],
                        int val[], int n)
    {
        int i, j;
        int K[][] = new int[n + 1][W + 1];
 
        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++)
        {
            for (j = 0; j <= W; j++)
            {
                if (i == 0 || j == 0)             //  The base condition changes into initialisation step
                    K[i][j] = 0;                 
                else if (wt[i - 1] <= W)
                    K[i][j]
                        = max(val[i - 1]
                         + K[i - 1][j - wt[i - 1]],
                         K[i - 1][j]);
                else
                    K[i][j] = K[i - 1][j];
            }
        }
 
        return K[n][W];
    }
 
    // Driver code
    public static void main(String args[])
    {
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
    }
}
/*Complexity Analysis: 

Time Complexity: O(N*W). 
where ‘N’ is the number of weight element and ‘W’ is capacity. As for every weight element we traverse through all weight capacities 1<=w<=W.
Auxiliary Space: O(N*W). 
The use of 2-D array of size ‘N*W’.*/