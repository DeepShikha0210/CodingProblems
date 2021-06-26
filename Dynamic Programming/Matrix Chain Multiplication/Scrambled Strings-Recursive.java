package CreatingSolutions;

import java.util.Arrays;

class Solution{

    static boolean solve(String A, String B){

        if(A.compareTo(B)==0)
            return true;

        if (((A.length() == 0 || B.length() == 0)) || (A.length() != B.length()))
            return false;

        int n = A.length();

        char[] Astring = A.toCharArray();
        char[] Bstring= B.toCharArray();
        
        Arrays.sort(Astring);
        Arrays.sort(Bstring);

        String copyA = new String(Astring);
        String copyB = new String(Bstring);

        if (!copyA.equals(copyB))
        return false;

        for(int i =1; i< A.length(); i++)
        {
            if
            (((solve(A.substring(0, i), B.substring(n - i))) &&  (solve(A.substring(i), B.substring(0, n-i))))
                    //swap
                    ||   //or
					
            ((solve(A.substring(0, i), B.substring(0, i))) &&  (solve(A.substring(i), B.substring(i)))))
                   //no swap
                return true;

        }
        return false;

    }

    public static void main(String[] args)
    {
        String S1 = "coder";
        String S2 = "ocred";

        System.out.println(solve(S1, S2));
    }
}