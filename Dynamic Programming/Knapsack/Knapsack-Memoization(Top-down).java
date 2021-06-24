/* 0-1 Knapsack Problem:
 Given weights and values of n items, put these items in a knapsack of capacity W to get 
 the maximum total value in the knapsack. In other words, given two integer arrays val[0..n-1] 
 and wt[0..n-1] which represent values and weights associated with n items respectively. Also 
 given an integer W which represents knapsack capacity, find out the maximum value subset of 
 val[] such that sum  of the weights of this subset is smaller than or equal to W. You cannot 
 break an item, either pick the complete item, or don’t pick  it (0-1 property).
 
Input:=
 Items:   I1 I2 I3 I4
Weight[] = 1  3  4  5
Value [] = 1  4  5  7
W(capacity) = 7
Optimise/Maximise profit!
Output:=
int maxProfit


1)W1<=W if false i.e, if W1 > W we have to leave it and move on.
2)If true, we have to options , 
option 1 :  take it 
option 2 :  not take it.
*/
class Solution{
int knapsack(int[] weight, int[] value, int n , int W) //RECURSIVE APPROACH
{
   //BASE CONDITION
   if(n==0 || W==0)
   return 0;
   
   if( w[n-1] > W)
   return knapsack(weight,value, n-1 , W);
    
   else
   return  Math.max((w[n-1] + knapsack(weight,value, n-1 , W-w[n-1]) ),knapsack(weight,value, n-1 , W));
}
}

/*Complexity Analysis: 

Time Complexity: O(2n). 
As there are redundant subproblems.
Auxiliary Space :O(1). 
As no extra data structure has been used for storing values.*/
/************************************************************************************************/



/*Find the changing variables in the recursive equation based on which dp[][] will be created.

here dp[n+1]{W+1]
*/
class Solution{             //MEMOIZATION APPROACH-TOP-DOWN(an extension of recursive approach).
	
static int knapSack(int W, int wt[], int val[], int N)
{ 
     
    // Declare the table dynamically
    int dp[][] = new int[N + 1][W + 1];
     
    // Loop to initially filled the
    // table with -1
    for(int i = 0; i < N + 1; i++)  
        for(int j = 0; j < W + 1; j++)  
            dp[i][j] = -1;   
     
    return knapSackRec(W, wt, val, N, dp);    
}

// Here is the top-down approach of 
// dynamic programming

     
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
    return dp[n][W] = Math.max((val[n - 1] +  knapSackRec(W - wt[n - 1], wt, val, n - 1, dp)), knapSackRec(W, wt, val, n - 1, dp)); 
}
}										  
/*int[][] dp = new int[n+1][W+1];  
for(int[] arr1 : dp) 
  Arrays.fill(arr1, -1);*/

/*
Complexity Analysis: 

Time Complexity: O(N*W). 
As redundant calculations of states are avoided.
Auxiliary Space: O(N*W). 
The use of 2D array data structure for storing intermediate states-:
*/

/*
for(int i = 0; i < N + 1; i++) {
            for (int j = 0; j < W + 1; j++)
                System.out.print(dp[i][j] + " ");
            System.out.println();
        }*/