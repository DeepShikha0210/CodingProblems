package CreatingSolutions;

class Solution {


    /* Function to get minimum number of trials needed in worst case with e eggs and f floors */

    static int eggDrop(int e, int f)
    {
        /* A 2D table where entry eggFloor[i][j]
 will represent minimum number of trials
needed for i eggs and j floors. */
        int eggFloor[][] = new int[e + 1][f + 1];
        int res;
        int i, j, k;

        // We need one trial for one floor and
        // 0 trials for 0 floors

        for (i = 1; i <= e; i++) {
            eggFloor[i][1] = 1;
            eggFloor[i][0] = 0;
        }

        // We always need j trials for one egg
        // and j floors.

        for (j = 1; j <= f; j++)
            eggFloor[1][j] = j;

        // Fill rest of the entries in table using
        // optimal substructure property
        for (i = 2; i <= e; i++) {
            for (j = 2; j <= f; j++) {
                eggFloor[i][j] = Integer.MAX_VALUE;

                for (k = 1; k <= j; k++) {
                    res = 1 + Math.max( eggFloor[i - 1][k - 1], eggFloor[i][j - k]);
                    eggFloor[i][j]= Math.min(res, eggFloor[i][j]);
                }
            }
        }

        // eggFloor[n][k] holds the result
        return eggFloor[e][f];
    }

    /* Driver program to test to pront printDups*/
    public static void main(String args[])
    {
        int e = 2, f = 36; //8
        System.out.println("Minimum number of trials in worst"+ " case with " + e + "  eggs and " + f + " floors is " + eggDrop(e, f));
    }
}