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

            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            for (int i = 0; i < A.size(); i++) {
                minHeapHeap.add(A.get(i));
                if (minHeap.size() > k) {
                    minHeap.poll();
                }
            }
            return minHeap.peek();
        }
    }

//Reduces sorting complexity from nlogn to nlogk