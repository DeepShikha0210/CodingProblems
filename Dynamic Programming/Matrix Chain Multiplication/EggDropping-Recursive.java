package CreatingSolutions;

class Solution{

    static int solve(int e, int f)
    {

        if((e == 1)|| (f==0 || f == 1))
            return f;

        int min = Integer.MAX_VALUE;

        for(int k = 1; k <= f; k++)
        {
            int temp = 1 + Math.max(solve(e-1, k-1) , solve (e, f-k)); // to check worst case
            min = Math.min(min, temp);  //minimum number of attempts

        }

        return min;

    }

    public static void main(String[] args)
    {
        int e = 3;
        int f = 5;

        System.out.println(solve(e, f));
    }

}	
   
