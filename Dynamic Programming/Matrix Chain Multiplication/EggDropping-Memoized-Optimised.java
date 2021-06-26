package CreatingSolutions;

import java.util.Arrays;

class Solution {

    static int[][] dp;

    private static int eggDrop(int eggs, int floors) {

        if (floors == 0 || floors == 1)
            return floors;

        if (eggs == 1)
            return floors;

        if (dp[eggs][floors] > -1)
            return dp[eggs][floors];

        int MIN_ATTEMPTS = Integer.MAX_VALUE;

        // Why k = 1 since it's not array which can start from 0th floor/index
        // hence we start from floor 1 and go till end of floor.
        for (int k = 1; k <= floors; k++) {
            // if egg breaks at kth floor
            // At this k we tried so 1 attempt is consumed.
            // Now at this either a egg can break or can't break and since we want worst case so we choose Max or either 2

            //case 1: WHEN EGG BREAKS -- we check floors below K
            int floorBelowK ;

            if (dp[eggs - 1][k - 1] > -1) {
                floorBelowK = dp[eggs - 1][k - 1];
            }
            else {
                floorBelowK = eggDrop(eggs - 1, k - 1);
                dp[eggs - 1][k - 1] = floorBelowK;
            }

            //case 2: WHEN EGG DOES NOT BREAK -- we check floors above K
            int floorAboveK;

            if (dp[eggs][floors - k] > -1) {
                floorAboveK = dp[eggs][floors - k];
            } else {
                floorAboveK = eggDrop(eggs, floors - k);
                dp[eggs][floors - k] = floorAboveK;
            }

            // why +1 because we are attempting at k.
            int worstCase = 1 + Math.max(floorBelowK, floorAboveK);
            MIN_ATTEMPTS = Math.min(MIN_ATTEMPTS, worstCase);
        }
        return dp[eggs][floors] = MIN_ATTEMPTS;
    }

    public static void main(String[] args)
    {
        int eggs = 2, floors = 36; //8

        dp = new int[eggs + 1][floors + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        System.out.println("Minimum number of trials in worst"+ " case with " + eggs + "  eggs and " + floors + " floors is " + eggDrop(eggs, floors));
    }
}	
	