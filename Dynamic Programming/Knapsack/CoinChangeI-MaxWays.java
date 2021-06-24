/*Coin Change Problem Maximum Number of ways
Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins doesn’t matter.
Example:
for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4.*/

class Solutions{

public static coinChange(int coins[] , int N)
{
   int n=coins.length;
   int[][] dp = new int[n+1][N+1];
   
   for(int i=0; i< N; i++)
   {
     for(int j = 0; j< n; n++)
	  {
	    if(i!=0 && j==0)
		 dp[i][j]= 1;
		 
		  if(i==0 && j!=0)
		 dp[i][j]= 0;
		 
		if(coins[i-1] > N)
         dp[i][j] = dp[i-1][j];
        
        else		
		 dp[i][j] = dp[i][[j- coins[i-1]] + dp[i-1][j];
	  }
	}

    return dp[n][W];	
   
}