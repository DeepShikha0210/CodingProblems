//MATRIX CHAIN MULTIPLICATION
/*
 Given a sequence of matrices, find the most efficient way to multiply these matrices together.
 The problem is not actually to  perform the multiplications, but merely to decide in which order 
 to perform the multiplications.
 */

//Format for MCM:

   int ans = 0;
   int solve(int[] arr, int i, int j){
   
   if(i> j)           //base condition
   return 0;
   
   for(int k = i; k < j ; k++){
   
   //calculate temp ans
   int tempAns = solve(arr, i, k) + solve(arr, k+1, j);
   
   ans = function(tempAns ); // min, max, etc
   return ans;
   
   }
   
   }
   
   
   /*
   Step 1: Find initial i and j value
   Step 2: Determine the correct base condition
   Step 3: Find the valid initial and final values of K i.e. the K loop scheme.
   Step 4: Calculate answer from temporary answer.
   */
/***********************************************************************************************/
package CreatingSolutions;
class Solution {
    // Matrix Ai has dimension p[i-1] x p[i] for i = 1..n
    static int MatrixChainOrder(int p[], int i, int j)
    {
        if (i == j)
            return 0;

        int min = Integer.MAX_VALUE;

        // place parenthesis at different places between
        // first and last matrix, recursively calculate
        // count of multiplications for each parenthesis
        // placement and return the minimum count
        for (int k = i; k < j; k++)
        {
            int count = MatrixChainOrder(p, i, k)+ MatrixChainOrder(p, k + 1, j) + p[i - 1] * p[k] * p[j];

            if (count < min)
                min = count;

            // min = Math.min(min, count);
        }

        // Return minimum count
        return min;
    }

    // Driver code
    public static void main(String args[])
    {
        int arr[] = new int[] { 1, 2, 3, 4, 3 };
        int n = arr.length;

        System.out.println(
                "Minimum number of multiplications is " + MatrixChainOrder(arr, 1, n - 1));
    }
}

/************************************************************************************************
The time complexity of the above naive recursive approach is exponential. It should be noted that 
the above function computes the same subproblems again and again.
*/