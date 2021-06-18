//Subset Problem
/*
Subset Sum Problem(Dynamic Programming)
Given a set of non-negative integers, and a value sum, determine if there is a subset of the 
given set with sum equal to given sum.

Example:

Input:  set[] = {3, 34, 4, 12, 5, 2}, sum = 9
Output:  True  //There is a subset (4, 5) with sum 9.

*/

class Solution{                      //METHOD I - Recursive

     boolean subsetProblem(int[] set, int sum, int n)
	 {
	   if n == 0
	   return false;  
	   if sum==0
	   return true;
	   
	   if(set[n-1] <=sum)
	   return subsetProblem(set, sum-set[n-1] , n-1) || subsetProblem(set, sum, n-1);
	   
	   else if(set[n-1] >sum )
	   return  subsetProblem(set, sum, n-1);  
	   
	 }
	 
}	 

class Solution{                      //METHOD II - Memoization

     boolean subsetProblem(int[] set, int sum, int n)
	 {
	   boolean[][] dp = new boolean[n+1][sum+1];
	   
	   for(int i = 0; i < n + 1; i++)  
        for(int j = 0; j < sum + 1; j++)  
            dp[i][j] = false; 
			
	   if n == 0
	   return false;  
	   if sum==0
	   return true;
	   
	   
	   
	   if(set[n-1] <=sum)
	   return dp[n][sum] = subsetProblem(set, sum-set[n-1] , n-1) || subsetProblem(set, sum, n-1);
	   
	   else if(set[n-1] >sum )
	   return  dp[n][sum] = subsetProblem(set, sum, n-1);  
	   
	 }
}	 

class Solution{                      //METHOD III - Bottom-Up Approach

     boolean subsetProblem(int[] set, int sum, int n)
	 {
	    int i, j;
        boolean[][] K = new int[n + 1][sum + 1];
		
		
		// If sum is 0, then answer is true
        for (int i = 0; i <= n; i++)      // i==0 imply empty set which is possible if sum=0
            K[0][i] = true;
 
        // If sum is not 0 and set is empty,
        // then answer is false
        for (int i = 1; i <= sum; i++)
            K[i][0] = false;
 
 
        // Build table K[][] in bottom up manner
   
	   for(int i = 0; i < n + 1; i++) { 
          for(int j = 0; j < sum + 1; j++) {
		   		
          	if(set[i-1] <=j)
	       K[i][j] = K[i-1][j-set[i-1]] || K[i-1][j];
	   
	        else if(set[i-1] >j)
	        K[i][j] = K[i-1][j];  
			}
		}
		return dp[n][sum];	
	   
	 }
}	