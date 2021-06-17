import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>();
        A.add(7);
        A.add(10);
        A.add(4);
        A.add(3);
        A.add(20);
        A.add(15);
		
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
                    minHeap.poll();

                }
            }
        while(!minHeap.isEmpty())
            output.add(minHeap.poll());

        return output;
    }
}
/************************************************************************************/
public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = A.size()-1;i>=0&&B-->0; i--) {
            res.add(A.get(i));
        }
        return res;
    }
}
