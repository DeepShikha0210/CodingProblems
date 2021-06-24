/*BOTTOM-UP APPROACH
1) The base condition changes into initialisation step
2) Replace n and W i.e. the varying ones in the recursive step to i and j respectively.

For example:

//max((val[n - 1] + knapSackRec(W - wt[n - 1], wt, val, n - 1, dp)), knapSackRec(W, wt, val, n - 1, dp)); 

//max(val[i - 1] + K[i - 1][j - wt[i - 1]],  K[i - 1][j]);


*/
// A Dynamic Programming based solution
// for 0-1 Knapsack problem
class Solution{


    // A utility function that returns
// maximum of two integers

    // Returns the value of maximum profit
    static int knapSackRec(int W, int wt[], int val[], int n, int [][]dp)
    {

        // Base condition
        if (n == 0 || W == 0)
            return 0;

        if (dp[n][W] != -1)
            return dp[n][W];

        if (wt[n - 1] > W)

            // Store the value of function call
            // stack in table before return
            return dp[n][W] = knapSackRec(W, wt, val, n - 1, dp);

        else

            // Return value of table after storing
            return dp[n][W] = Math.max((val[n - 1] + knapSackRec(W - wt[n - 1], wt, val, n , dp)),
                    knapSackRec(W, wt, val, n - 1, dp));
    }

    static int knapSack(int W, int wt[], int val[], int N)
    {

        // Declare the table dynamically
        int dp[][] = new int[N+1][W+1];

        // Loop to initially filled the
        // table with -1
        for(int i = 0; i < N + 1; i++)
            for(int j = 0; j < W + 1; j++)
                dp[i][j] = -1;

        //Printing the dp[][]
		
       /* for(int i = 0; i < N + 1; i++) {         
            for (int j = 0; j < W + 1; j++)
                System.out.print(dp[i][j] + " ");
            System.out.println();
        }*/  

        return knapSackRec(W, wt, val, N, dp);
    }

    // Driver Code
    public static void main(String [] args)
    {
        int val[] = { 10,40, 50,70 };
        int wt[]  = { 1, 3,  4, 5 };

        int W = 8;
        int N = val.length;

        System.out.println(knapSack(W, wt, val, N));
    }
}
/*Complexity Analysis: 

Time Complexity: O(N*W). 
where ‘N’ is the number of weight element and ‘W’ is capacity. As for every weight element we traverse through all weight capacities 1<=w<=W.
Auxiliary Space: O(N*W). 
The use of 2-D array of size ‘N*W’.*/