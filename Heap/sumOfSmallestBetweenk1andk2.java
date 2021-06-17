package CreatingSolutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;


public class Solution {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>();
        A.add(20);
        A.add(8);
        A.add(22);
        A.add(4);
        A.add(12);
        A.add(10);
        A.add(14);

        //Input : arr[] = {20, 8, 22, 4, 12, 10, 14},  k1 = 3,  k2 = 6
        //Output : 26

        System.out.println(solve(A , 3, 6));
    }


//METHOD I

    public static int solve( ArrayList<Integer> A , int k1, int k2)
    {
        ArrayList<Integer> output = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int k = k2>k1 ? k2 : k1; //taking the larger one
        int p = k2>k1 ? k1: k2;

        for(int i=0; i<A.size(); i++) {
            maxHeap.add(A.get(i));
            if(maxHeap.size()>k)
                maxHeap.poll();

        }
        int sum=0;
        maxHeap.poll();
        while(maxHeap.size() > p)
            sum+=maxHeap.poll();

        return sum;
    }
}

/*******************************************************************************/
//Method II

public static int solve( ArrayList<Integer> A , int k1, int k2)
    {
        ArrayList<Integer> output = new ArrayList<>();
        int first=kthSmallest(A,k1);
        int second =kthSmallest(A,k2);

        int i =0, sum=0;
        while(i< A.size())
        {
            if(A.get(i) > first && A.get(i) < second)
                  sum+=A.get(i);
            i++;
        }
        return sum;
    }

    public static int kthSmallest( ArrayList<Integer> A, int k) {

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