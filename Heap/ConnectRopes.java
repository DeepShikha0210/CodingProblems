package CreatingSolutions;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>();
        A.add(4);
        A.add(3);
        A.add(2);
        A.add(6);
        System.out.println(solve(A));
    }

    public static int solve( ArrayList<Integer> A)
    {
    
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int price=0;
        for(int i=0; i<A.size(); i++)
            minHeap.add(A.get(i));

        while(minHeap.size() > 1)
        {
            int toBeAdded = minHeap.poll()+ minHeap.poll();
            price=price+toBeAdded;
            minHeap.add(toBeAdded);
        }
        return price;
    }
}
