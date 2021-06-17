/*TRIES in competitive programming*/

Given an array of N integers, we have to find maximum result of (nums[i] ^ nums[j]) where
0 <= i <= j < N.
Constraints:
<# 1 <=N<= 2* 10^5
<# 0 <= array element < 2^31-1

Hint 1: Can binary representation of each element help?
Hint 2: Suppose we have a data structure which can satisfy two types of queries:
        > Insert a number X
		>Given a Y, find the maximum xor of Y with all the numbers that have been inserted 
		  till now.
ith bit = (num>>i)&1
XOR table:
0^0 = 0
0^1 = 1
1^0 = 1
1^1 = 0

*/

class TrieNode{

  TrieNode left;
  TrieNode right;
  TrieNode()
  {
    left = null;
	right=null;

  }
  }

class Solution{

   public void insert( int n, TrieNode root)
   {
      TrieNode current = root;
     for(int i = 31; i >= 0 ; i--)
        {
           int bit = (n>>j)&1;
           if(bit == 0)
             {
               if(current.left == null)
                 current.left = new TrieNode();                  
                 current=current.left;
			 }	 
		  else
		  {
              if(current.right == null)
                 current.right = new TrieNode();                  
                 current=current.right;
			}
		}
		return root;
   
   }
   
   int findMaximumXor(ArrayList<Integer> A)
   {
     TrieNode root = new TrieNode();
	 for(int i = 0; i< A.size(); i++)
	   root = insert(A.get(i), root);
     return maxXorPair(root, A);
   }

int maxXorPair(TrieNode root, ArrayList<Integer> A)
  {

   int maxXor = Integer.MIN_VALUE;
   for(int i = 0; i< A.size(); i++)
    {

     TrieNode current = root;
	 int value =A.get(i);
	 int currentXor = 0;
     for(int j = 31; j >= 0 ; j--)
        {
           int bit = (value>>j)&1;
           if(bit == 0)
             {
               if(current.right != null)
                 {
				 currentXor+=Math.pow(2,j);
                 current=current.right;
                  }
                else
                 current=current.left;
			}	 
		  else
		  {
               if(current.left != null)
                 {
				 currentXor+=Math.pow(2,j);
                 current=current.left;
                  }
                else
                 current=current.right;
			}
		}
      maxXor=Math.max(maxXor, currentXor);
	  }
	  
	  return maxXor;
	 } 
} 