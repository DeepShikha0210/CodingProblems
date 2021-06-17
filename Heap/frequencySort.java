

    public class Pair<I extends Number, I1 extends Number> {
        int first;
        int second;

        Pair() { first = 0; second = 0; }
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

/***********************************************************************************/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(1);
        A.add(1);
        A.add(3);
        A.add(2);
        A.add(2);
        A.add(4);

        System.out.println(solve(A));
    }

    public static ArrayList<Integer> solve( ArrayList<Integer> A)
    {
        ArrayList<Integer> output = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< A.size(); i++)
        {
            map.put(A.get(i) , map.getOrDefault(A.get(i), 0)+1);

        }
        PriorityQueue<Pair<Integer,Integer>> maxHeap = new PriorityQueue<>((Pair a, Pair b) ->
        {   if(a.second == b.second)
                return a.first-b.first;

            return b.second - a.second;
        });

        Set<Integer> set = map.keySet();
        for(Integer key : set)
        {
            maxHeap.add(new Pair<>(key , map.get(key)));
        }

        while(!maxHeap.isEmpty())
        {
            output.add(maxHeap.peek().first);
            maxHeap.peek().second--;
            if (maxHeap.peek().second == 0)
                maxHeap.poll();
        }
        return output;
    }
}
