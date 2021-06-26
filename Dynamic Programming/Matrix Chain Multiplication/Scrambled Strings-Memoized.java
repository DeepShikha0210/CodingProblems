package CreatingSolutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution{

    static Map<String, Boolean> memorization;

    static boolean solve(String A, String B){

        String key = A + ":" + B;
        if (memorization.containsKey(key)) return memorization.get(key);

        if (A.compareTo(B) == 0) {
            memorization.put(key, true);
            return true;
        }



        if (((A.length() == 0 || B.length() == 0)) || (A.length() != B.length()))
            return false;

        int n = A.length();
        boolean scrambleStrings = false;

        //char[] Astring = A.toCharArray();
        //char[] Bstring= B.toCharArray();

        //Arrays.sort(Astring);
        //Arrays.sort(Bstring);

        //String copyA = new String(Astring);
        //String copyB = new String(Bstring);

        //if (!copyA.equals(copyB))
          //  return false;

        for(int i =1; i< A.length(); i++)
        {
            if
            (((solve(A.substring(0, i), B.substring(n - i))) &&  (solve(A.substring(i), B.substring(0, n-i))))
                    //swap
                    ||   //or

            ((solve(A.substring(0, i), B.substring(0, i))) &&  (solve(A.substring(i), B.substring(i)))))
            //no swap
            {
                scrambleStrings = true;
                break;
            }
        }
        memorization.put(key, scrambleStrings);
        return scrambleStrings;
    }

    public static void main(String[] args)
    {
        String A = "coder";
        String B = "ocred";

        // Memorization
        memorization = new HashMap<>();

        System.out.println(solve(A, B));
    }
}