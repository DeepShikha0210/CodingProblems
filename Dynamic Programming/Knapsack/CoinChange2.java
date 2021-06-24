class Solutions{

public static coinChange(int coins[] , int N)
{
   int n=coins.length;
   int[][] dp = new int[n+1][N+1];
   
   for(int i=0; i< N; i++)
   {
     for(int j = 0; j< n; n++)
	  {
	    if(i==0)
		 dp[i][j]= Integer.MAX_VALUE-1;   //Add according to given constraints
		 
		 
		if(coins[i-1] > N)
         dp[i][j] = dp[i-1][j];
        
        else		
		 dp[i][j] = Math.min(1 + dp[i][[j- coins[i-1]] + dp[i-1][j]);
	  }
	}
    if (dp[n][W]  == Integer.MAX_VALUE)
	    return -1;
		
    return dp[n][W];	
   
}

/*********************************************************************************************/
class Solution
{
    // n is size of coins array
    // (number of different coins)
    static int minCoins(int coins[], int n, int N)
    {
        // table[i] will be storing
        // the minimum number of coins
        // required for i value. So
        // table[V] will have result
        int table[] = new int[N + 1];
 
        // Base case (If given value N is 0)
        table[0] = 0;
 
        // Initialize all table values as Infinite
        for (int i = 1; i <= N; i++)
        table[i] = Integer.MAX_VALUE;
 
        // Compute minimum coins required for all
        // values from 1 to N
        for (int i = 1; i <= N; i++)
        {
            // Go through all coins smaller than i
            for (int j = 0; j < n; j++)
            if (coins[j] <= i)
            {
                int sub_res = table[i - coins[j]];
                if (sub_res != Integer.MAX_VALUE  && sub_res + 1 < table[i])
                       table[i] = sub_res + 1;
                        
                 
            }
             
        }
       
          if(table[N]==Integer.MAX_VALUE)
            return -1;
       
        return table[N];
         
    }
 
    // Driver program
    public static void main (String[] args)
    {
        int coins[] = {9, 6, 5, 1};
        int n = coins.length;
        int N = 11;
        System.out.println ( "Minimum coins required is " + minCoins(coins, n, N));
    }
}