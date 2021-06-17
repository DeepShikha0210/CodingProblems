/*
Min-max Query:
1) Brute force(Linear search) - build O(Q), Q(#queries) O(NQ), Update-O(1)

2) Prefix sum array - build O(N),  Q(#queries) O(1),   Update-O(N)

3) 2D Array : update O(N^2)  queries O(1)

3) Segment tree - build O(N), update(Ologn)


Segment Tree:
>full binary trre
>based on divide and conquer

     i(1-based)
    / \
  2i  (2i+1)
  
     i(0-based)
    / \
(2i+1)(2i+2)

Maximum size of array required = 4N+1
Minimum size of array required = 2N-1

*/
int query(int[] tree, int index, int start, int end, int queryStart, int queryEnd)
 //QUERY FOR MIN IN RANGE
{
//Case 1: No overlap
if(queryStart > end || queryEnd < start)
return Integer.MAX_VALUE;
//Case 2: Complete overlap

if(start>=queryStart && end<=queryEnd)
    return tree[index];

//Case 3: Partial overlap -call both sides

int mid = (start+end)/2;
int leftAns = query(tree, 2*index, start, mid, queryStart, queryEnd);
int rightAns = query(tree, 2*index+1, mid, end, queryStart, queryEnd);
return Math.min(leftAns, rightAns);     

}


	