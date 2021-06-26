package CreatingSolutions;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private static final String EMPTY_STRING = "";
    static Map<String, Integer> memorization;

    public static void main(String[] args){
        String str = "T|T&F^T";
        char[] input = str.toCharArray();
        memorization = new HashMap<>();

        System.out.println("Number of ways " + "to evaluate true is " + solve(input, 0, input.length - 1,true));
    }

    // Why map since in this question there are 3 variables which are changing
    //  and visualizing 3d matrix is not very intuitive.

    private static int solve(char[] input, int i, int j, boolean isTrue) {
        String key = EMPTY_STRING + i + j + isTrue;
        if (memorization.containsKey(key)) return memorization.get(key);
        if (i > j) {
            memorization.put(key, 0);
            return 0; // Empty String there are no ways.
        }
        if (i == j) {
            if (isTrue) {
                memorization.put(key, input[i] == 'T' ? 1 : 0);
                return input[i] == 'T' ? 1 : 0;
            } else {
                memorization.put(key, input[i] == 'F' ? 1 : 0);
                return input[i] == 'F' ? 1 : 0;
            }
        }

        int answer = 0;
        for (int k = i + 1; k < j; k += 2) {
            String partialLeftKeyTrue = EMPTY_STRING + i + (k - 1) + "true";
            String partialLeftKeyFalse = EMPTY_STRING + i + (k - 1) + "false";
            String partialRightKeyTrue = EMPTY_STRING + (k + 1) + j + "true";
            String partialRightKeyFalse = EMPTY_STRING + (k + 1) + j + "false";
            int trueWaysInLeft = memorization.containsKey(partialLeftKeyTrue) ? memorization.get(partialLeftKeyTrue) : solve(input, i, k - 1, true);
            int falseWaysInLeft = memorization.containsKey(partialLeftKeyFalse) ? memorization.get(partialLeftKeyFalse) : solve(input, i, k - 1, false);
            int trueWaysInRight = memorization.containsKey(partialRightKeyTrue) ? memorization.get(partialRightKeyTrue) : solve(input, k + 1, j, true);
            int falseWaysInRight = memorization.containsKey(partialRightKeyFalse) ? memorization.get(partialRightKeyFalse) : solve(input, k + 1, j, false);

            // Now
            char operatorAtK = input[k];

            if (operatorAtK == '&') {
                if (isTrue) { // We have to find true with AND operator
                    // that's only possible when left is true and right is true
                    answer += trueWaysInLeft * trueWaysInRight;
                } else { // We have to find false with AND OPERATOR
                    answer += (trueWaysInLeft * falseWaysInRight) + (falseWaysInLeft * trueWaysInRight)
                            + (falseWaysInLeft * falseWaysInRight);
                }
            } else if (operatorAtK == '|') {
                if (isTrue) { // We have to find true with OR operator
                    // that's only possible when left is true and right is true
                    answer += (trueWaysInLeft * trueWaysInRight) +
                            (trueWaysInLeft * falseWaysInRight) +
                            (falseWaysInLeft * trueWaysInRight);
                } else { // We have to find false with OR OPERATOR
                    answer += falseWaysInLeft * falseWaysInRight;
                }
            } else if (operatorAtK == '^') {
                if (isTrue) { // We have to find true with XOR Operator
                    answer += (trueWaysInLeft * falseWaysInRight) + (falseWaysInLeft * trueWaysInRight);
                } else {
                    answer += (falseWaysInLeft * falseWaysInRight) + (trueWaysInLeft * trueWaysInRight);
                }
            }
        }
        memorization.put(key, answer);
        return answer;
    }


}