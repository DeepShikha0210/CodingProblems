//Boolean Strings
//Count number of such strings who have no consecutive ones

public static int solve(int n)
{
if(n==0)
return 1;

if(n<0)
return 0;

return solve(n-1) + solve(n-2);

}

