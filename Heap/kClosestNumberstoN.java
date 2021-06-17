

    public class Pair<I extends Number, I1 extends Number> {
        int first;
        int second;

        Pair() { first = 0; second = 0; }
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

/**********************************************************************************/

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>();
    
        A.add(5);
        A.add(6);
        A.add(7);
        A.add(8);
        A.add(9);
        
        int k=3;
        System.out.println(solve(A , k, 7));
    }

    public static ArrayList<Integer> solve( ArrayList<Integer> A, int k, int n)
    {
        ArrayList<Integer> output = new ArrayList<Integer>();
        PriorityQueue<Pair<Integer, Integer>> maxHeap = new PriorityQueue<>((Pair a, Pair b) -> {
            if (b.first - a.first==0)
                return b.second - a.second;
            return b.first - a.first; });

        for (int i = 0; i < A.size(); i++) {
            maxHeap.add(new Pair(Math.abs(A.get(i)-n),A.get(i)));
            if (maxHeap.size() > k) {
                maxHeap.poll();
                }
            }
        while(!maxHeap.isEmpty())
            output.add(maxHeap.poll().second);

        return output;
    }
}
