class Solution {
    
    //Recursive+Memoization : Similar to Unbounded Knapsack
    public int solve(int[] coins,int n,int amt,int dp[][])
    {
        
        if(n==0)
        {
            return 1000;
        }
        if(amt<=0)
        {
            return 0;
        }
        
        if(dp[n][amt]!=-1)
        {
            return dp[n][amt];
        }
        if(coins[n-1]<=amt)
        {
            //You have two choices: 
            //1: Either you take this coin and subtract its value from amt; Count of coins will inc by 1.
            //2: Don't take this coin.
            return dp[n][amt]=Math.min(1+solve(coins,n,amt-coins[n-1],dp),
            solve(coins,n-1,amt,dp));
        }
        else
        {
            //You can't take this coin as its value is greater than amt you have in hand.
            return dp[n][amt]=solve(coins,n-1,amt,dp);
        }
    }

    
    
    public int coinChange(int[] coins, int amount) {
        
        int dp[][]=new int[coins.length+1][amount+1];
        for(int t[]: dp)
        {
            Arrays.fill(t,-1);
        }
        int ans=solve(coins,coins.length,amount,dp);
        if(ans==1000)
        {
            return -1;
        }
        else
        {
            return ans;
        }
        
    }
}