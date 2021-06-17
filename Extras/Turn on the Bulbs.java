//Problem Description:

/* There are A bulbs lined ina a row numbered 1 to A, which are off initiatlly. In one step you can choose any bulb and turn it on.
If you turn on x , it will also turn x-2 and x+2. Find the minimum steps required to turn on all the bulbs. */

public class Solution {
    public int solve(int A) {
     
        return (A/6)*2 + Math.min(A%6 , 2);
        
    }
}

