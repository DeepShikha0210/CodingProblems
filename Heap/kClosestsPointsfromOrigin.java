package CreatingSolutions;


    public class Pair<I extends Number, I1 extends Number> {   //PAIR CLASS implementation
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
import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> A = new ArrayList<>(10);
        A.add(new ArrayList<Integer>(Arrays.asList(1,3)));
        A.add(new ArrayList<Integer>(Arrays.asList(-2,2)));
        A.add(new ArrayList<Integer>(Arrays.asList(5,8)));
        A.add(new ArrayList<Integer>(Arrays.asList(0,1)));


        System.out.println(solve(A , 3));
    }

    public static ArrayList<ArrayList<Integer>> solve( ArrayList<ArrayList<Integer>> A, int k)
    {
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();

        PriorityQueue<Pair<Integer,Integer>> maxHeap = new PriorityQueue<>((Pair a, Pair b) -> b.second - a.second);

        for(int i = 0, j=0; i < A.size(); i++)
        {
            int x2= (int) Math.pow(A.get(i).get(0), 2);
            int y2= (int) Math.pow(A.get(i).get(1), 2);

            maxHeap.add(new Pair<Integer, Integer>(i, x2+y2));
            if(maxHeap.size()>k)
                maxHeap.poll();
        }

        int i = 0;
        while(!maxHeap.isEmpty())
        {
            Pair p =maxHeap.poll();
            output.add(new ArrayList<Integer>(Arrays.asList(A.get(p.first).get(0),A.get(p.first).get(1))));
            i++;
        }

        return output;
    }
}
