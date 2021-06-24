/*
ROD-CUTTING PROBLEM
*/
// A Dynamic Programming solution for Rod cutting problem
class RodCutting
{
    /* Returns the best obtainable price for a rod of
       length n and price[] as prices of different pieces */
    static int cutRod(int price[],int n)
    {
        int val[] = new int[n+1];
        val[0] = 0;
 
        // Build the table val[] in bottom up manner and return
        // the last entry from the table
        for (int i = 1; i<=n; i++)
        {
            int max_val = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++)
                max_val = Math.max(max_val,  price[j] + val[i-j-1]);
            val[i] = max_val;
        }
 
        return val[n];
    }
 
    /* Driver program to test above functions */
    public static void main(String args[])
    {
        int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
        int size = arr.length;
        System.out.println("Maximum Obtainable Value is " +
                            cutRod(arr, size));
    }
}
/**********************************************************************************/
class Solution
{
    // Function to find the best way to cut a rod of length `n`
    // where the rod of length `i` has a cost `price[i-1]`
    public static int rodCut(int[] price, int n)
    {
        // `T[i]` stores the maximum profit achieved from a rod of length `i`
        int[] T = new int[n + 1];
 
        // consider a rod of length `i`
        for (int i = 1; i <= n; i++)
        {
            // divide the rod of length `i` into two rods of length `j`
            // and `i-j` each and take maximum
            for (int j = 1; j <= i; j++) {
                T[i] = Integer.max(T[i], price[j - 1] + T[i - j]);
            }
        }
 
        // `T[n]` stores the maximum profit achieved from a rod of length `n`
        return T[n];
    }
 
    public static void main(String[] args)
    {
        // int[] length = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int[] price = { 1, 5, 8, 9, 10, 17, 17, 20 };
        int n = 4;        // rod length
 
        System.out.print("Profit is " + rodCut(price, n));
    }
}


