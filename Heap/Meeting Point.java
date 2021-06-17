/*Problem Description
You and ypur friend decided to meet at one of the N locations in the city. Th ith location is located 
at A[i][0], A[i][1] on an indefinite grid. You want to meet at minimum x coordinate. If there sre 
multiple such locstions, choose the one with minimum y coordinate.
Your friend wants to meet st a location with minimum y coordinate.
you need to find the distance between theses two locations.
distance between (x1,y1) and (x2, y2) is |x1-x2| + |y1-y2|  */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> A = new ArrayList<>(10);
        A.add(new ArrayList<>(Arrays.asList(1, 3)));
        A.add(new ArrayList<>(Arrays.asList(7, 5)));
        //A.add(new ArrayList<>(Arrays.asList(4, 6)));
        //A.add(new ArrayList<>(Arrays.asList(0, 1)));

        System.out.println(solve(A));
    }

    public static int solve(  ArrayList<ArrayList<Integer>> A)
    {
        ArrayList<Integer> output = new ArrayList<>();
        int i = minimum(A, 0).peek().second;
        //System.out.println(i);
        int j = minimum(A, 1).peek().second;
        //System.out.println(j);

        int x1 = A.get(i).get(0);
        int y1 = A.get(i).get(1);
        int x2 = A.get(j).get(0);
        int y2 = A.get(j).get(1);


        return Math.abs(x1-x2)+ Math.abs(y1-y2);

    }

    public static PriorityQueue<Pair<Integer, Integer>> minimum( ArrayList<ArrayList<Integer>> A , int val) {

        int x = (val == 0) ? 1 : 0;
        PriorityQueue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>((Pair a, Pair b)->
        {
          if(a.first == b.first)
              return A.get(a.second).get(x) - A.get(b.second).get(x);
          return a.first-b.first;
        });

        //PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < A.size(); i++) {
            minHeap.add(new Pair<>(A.get(i).get(val), i));
        }
        return minHeap;
    }
}
