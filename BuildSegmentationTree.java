/*Building Segment tree

       0 1 2 3 4 5
For A=[1,2,3,4,5,6]

If there are N elements, there will be N-1 internal nodes and N leaf nodes. 
Therefore while building tree , we work on N + (N-1) = 2N-1 nodes.
Time complexity will be O(2N-1) ~ 0(N)

                        __________ A[0,5]__________
               ___A[0,2]___                     ___ A[3,5]___
      ___A[0,1]___        A[2,2]      ___ A[3,4]___           A[5,5]
A[0,0]            A[1,1]        A[3,3]          A[4,4]



The array built from tree will:
store the result of A[0,5] at index 1;
store the result of A[0,2] at index 2;
store the result of A[3,5] at index 3;
store the result of A[0,1] at index 4;
store the result of A[2,2] at index 5;
store the result of A[3,4] at index 6;
store the result of A[5,5] at index 7;
and so on.

The answer at index 4 will be depending upon the answer at index 8(2*4) and index 9(2*4+1).
The answer at index 3 will be depending upon the answer at index 6(2*3) and index 7(2*3+1).
This is why we're considering 1-based index.

*/

void buildTree(int[] A, int[] tree, int start, int end, int TreeNode ){ //RECURSIVE METHOD FOR BUILDING TREE

//base case
if(start>end)
return;

//base case - leaf node
if(start == end){
tree[TreeNode] = A[start];
return;
}
//build tree recursively

int mid= (start +end)/2;
//LEFT SUBTREE
buildTree(A, tree, start, mid , 2*TreeNode);
//RIGHT SUBTREE
buildTree(A, tree, mid, end , 2*TreeNode+1);
tree[TreeNode] = tree[2*TreeNode] + tree[2*TreeNode+1];          //for Sum query
tree[TreeNode] = Math.max(tree[2*TreeNode],tree[2*TreeNode+1]);  //for max query
tree[TreeNode] = Math.min(tree[2*TreeNode],tree[2*TreeNode+1]);  //for min query

}

void main()
{
int A[]= {1,2,3,4,5};
int n = A.length;
int[] tree = new int[2n-1];   //minmun size required =2N-1
//int[] tree = new int[4n+1];  //maximum size required =4N-1

  
/************************************************************************************************/
public SegmentTree(int[] A)       //ITERATIVE METHOD FOR BUILDING TREE
{
 int n = A.length;
 tree = new int[2*n];
 
 System.arraycopy(A,0,tree, n, n);
 
 for(int i = n-1; i > 0 ; i--) 
 tree[i] = tree[2*i] + tree[2*i+1];
 //tree[i] = Math.max(tree[2*i],tree[2*i+1]);
 //tree[i] = Math.min(tree[2*i],tree[2*i+1]);
 
 /*public static void arraycopy(Object source_arr, int sourcePos,
                            Object dest_arr, int destPos, int len)
Parameters : 
source_arr : array to be copied from
sourcePos : starting position in source array from where to copy
dest_arr : array to be copied in
destPos : starting position in destination array, where to copy in
len : total no. of components to be copied.*/


//0th index is left empty


/************************************************************************************************/







