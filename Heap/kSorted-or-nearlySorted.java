import java.util.ArrayList;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>();
        A.add(9);
        A.add(10);
        A.add(8);
        A.add(3);
        A.add(2);
        A.add(5);
        A.add(6);
        
        int k=3;
        System.out.println(solve(A , k));
    }

    public static ArrayList<Integer> solve( ArrayList<Integer> A, int k)
    {
        ArrayList<Integer> output = new ArrayList<Integer>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < A.size(); i++) {
            minHeap.add(A.get(i));
            if (minHeap.size() > k) {
                    output.add(minHeap.poll());
                }
            }
        while(!minHeap.isEmpty())
            output.add(minHeap.poll());
        return output;
    }
}
