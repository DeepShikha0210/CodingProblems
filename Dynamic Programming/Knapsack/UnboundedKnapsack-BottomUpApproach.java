package CreatingSolutions;
class Solution {

    // A utility function that returns


    // Returns the maximum value that can
    // be put in a knapsack of capacity W
    static int knapSack(int W, int wt[], int val[], int n)
    {
        int i, w;
        int K[][] = new int[n + 1][W + 1];

        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++)
        {
            for (w = 0; w <= W; w++)
            {
                if (i == 0 || w == 0) {
                    K[i][w] = 0;

                }
                else if (wt[i - 1] <= w) {
                    K[i][w] = Math.max(val[i - 1] + K[i][w - wt[i - 1]], K[i - 1][w]);


                }
                else{
                    K[i][w] = K[i - 1][w];


            }
            }
        }

        for(int j = 0; j < n + 1; j++) {
            for (int k = 0; k < W + 1; k++) {
                System.out.print(K[j][k] + " ");
            }
            System.out.println();
        }

        return K[n][W];
    }

    // Driver code
    public static void main(String args[])
    {
        int val[] = new int[] { 1, 4, 5, 7};
        int wt[]  = new int[] { 1, 3, 4, 5};
        int W = 8;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
    }
}