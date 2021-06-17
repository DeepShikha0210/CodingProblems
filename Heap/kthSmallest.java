import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>();
        //ArrayList<Integer> B = new ArrayList<>();
        A.add(7);
        A.add(10);
        A.add(4);
        A.add(3);
        A.add(20);
        A.add(15);
        
        int k=3;
        System.out.println(solve(A , k));
    }

    public static int solve( ArrayList<Integer> A, int k) {

            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
			//PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
            for (int i = 0; i < A.size(); i++) {
                maxHeap.add(A.get(i));
                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
            return maxHeap.peek();
        }
    }

//reduces sorting comlexity from nlogn to (n + nlogk)