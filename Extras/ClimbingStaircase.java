/*Coutning ways to climb n level staircase

To reach a step you can take either jump 1 step , two step or maximum 3 step.
*/


public static int solve(int n)
{
if(n==0)
return 1;

if(n<0)
return 0;

return solve(n-1) + solve(n-2) + solve(n-3);

}


