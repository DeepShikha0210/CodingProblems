import java.util.*;

public class Solution {
    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();
        A.add(900);
        A.add(940);
        A.add(950);
        A.add(1100);
        A.add(1500);
        A.add(1800);

        B.add(910);
        B.add(1200);
        B.add(1120);
        B.add(1130);
        B.add(1900);
        B.add(2000);

        System.out.println("I m running1");
        System.out.println(solve(A,B));


      // int arr[] = { 9:00, 9:40, 9:50, 11:00, 15:00, 18:00 };
      // int dep[] = { 9:10, 12:00, 11:20, 11:30, 19:00, 20:00 };
    }

    public static int solve(ArrayList<Integer> A, ArrayList<Integer> B)
    {
        Collections.sort(A);
        Collections.sort(B);
        int minimumRequired = 1;
        int ongoing = 1;
        int i =1, j =0;
        while(i < A.size() && j < A.size())
        {
            if(A.get(i) < B.get(j))
            {
                ongoing++;
                i++;
            }

            else if(A.get(i) >= B.get(j))
            {
                ongoing--;
                j++;
            }

            if(ongoing > minimumRequired)
            {
                minimumRequired=ongoing;
            }
        }

        return minimumRequired;
    }

}