package CreatingSolutions;

import java.util.Arrays;

class Solution {

    static int[][][] dp = new int[1003][1003][2];

    static int countBoolean(char[] ch, int i, int j, boolean isTrue) {

        if (i > j) return 0;

        if (i == j) {
            if (isTrue)
                return ch[i] == 'T' ? 1 : 0;
            else
                return ch[i] == 'F' ? 1 : 0;
        }

        if (dp[i][j][getNumfrombool(isTrue)] != -1)
            return dp[i][j][getNumfrombool(isTrue)];
        int ans = 0;
        for (int k = i + 1; k < j; k += 2) {
            int lt = countBoolean(ch, i, k - 1, true);
            int lf = countBoolean(ch, i, k - 1, false);
            int rt = countBoolean(ch, k + 1, j, true);
            int rf = countBoolean(ch, k + 1, j, false);

            if (ch[k] == '&') {
                if (isTrue)
                    ans += lt * rt;
                else
                    ans += lt * rf + lf * rt + lf * rf;
            } else if (ch[k] == '|') {
                if (isTrue)
                    ans += lt * rf + lf * rt + lt * rt;

                else
                    ans += lf * rf;
            } else if (ch[k] == '^') {
                if (isTrue) ans += lt * rf + lf * rt;
                else ans += lf * rf + lt * rt;
            }
        }
        ans = ans % 1003;

        dp[i][j][getNumfrombool(isTrue)] = ans;

        return ans;
    }

    static int getNumfrombool(boolean isTrue) {
        if (isTrue)
            return 1;
        else
            return 0;
    }

    public static void main(String[] args) {
        String str = "T|T&F^T";
        char[] input = str.toCharArray();


        for (int[][] row : dp) {
            for (int[] rowColumn : row) {
                Arrays.fill(rowColumn, -1);
            }
        }

        System.out.println("Number of ways " + "to evaluate true is " + countBoolean(input, 0, input.length - 1, true));

    }
}