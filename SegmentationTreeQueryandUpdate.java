/*
Min-max Query:
1) Brute force(Linear search) - build O(Q), Q(#queries) O(NQ), Update-O(1)

2) Prefix sum array - build O(N),  Q(#queries) O(1),   Update-O(N)

3) 2D Array : update O(N^2)  queries O(1)

3) Segment tree - build O(N), update(Ologn)


Segment Tree:
>full binary tree
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
package CreatingSolutions;

class Solution{

    static int[]  tree;

    static void buildTree(int[] A, int tree[], int index, int start, int end){ //RECURSIVE METHOD FOR BUILDING TREE

//base case
        if(start>end)
            return;
//base case - leaf node
        if(start == end){
            tree[index] = A[start];
        }
//build tree recursively
        else {
            int mid = (start + end) / 2;
      //LEFT SUBTREE
            buildTree(A, tree, 2 * index, start, mid);
//RIGHT SUBTREE
            buildTree(A, tree, 2 * index+1, mid + 1, end);
            //tree[index] = tree[2*Tindex] + tree[2*index+1];          //for Sum query
            // tree[index] = Math.max(tree[2*index],tree[2*index+1]);  //for max query
            tree[index] = Math.min(tree[2 * index ], tree[2 * index + 1]);  //for min query
        }
    }

    static int query( int index, int start, int end, int queryStart, int queryEnd)
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
        int leftAns = query( 2*index, start, mid, queryStart, queryEnd);
        int rightAns = query( 2*index+1, mid+1, end, queryStart, queryEnd);
        return Math.min(leftAns, rightAns);

    }

    //O(logn)
    static void update(int index, int start, int end, int i, int value) //UPDATEING TREE WITH VALUE AT INDEX i
    {
        //Case 1: No overlap. Lying outside given range.
        if(i < start || i> end)
            return;

        // Reached leaf-node
        if(start == end){
            tree[index] = value;
            return;
        }
        //Case 2: Lying within range - i is lying between start and end indexes.
        int mid = (start+end)/2;
        update( 2*index, start, mid, i , value);
        update( 2*index+1, mid+1, end,  i , value);
        tree[index] = Math.min(tree[2*index], tree[2*index+1]);
        return;
    }

//Range Update function
//You will be given re and rs,
//Update every element in the given range with given value B

    //O(n)
    static void rangeUpdate( int index, int start, int end, int rangeStart, int rangeEnd, int value) {
        //Case 1: No overlap. Lying outside given range.
        if (rangeStart < start || rangeEnd > end)
            return;

        // Reached leaf-node
        if (start == end) {
            tree[index] += value;
            return;
        }
//Case 2: Partial overlap -call both sides
            int mid = (start + end) / 2;
            rangeUpdate(2 * index, start, mid, rangeStart, rangeEnd, value);
            rangeUpdate(2 * index + 1, mid + 1, end, rangeStart, rangeEnd, value);
            tree[index] = Math.min(tree[2 * index], tree[2 * index + 1]);
            return;

        }


        void pointUpdate(int index, int start, int end, int i, int value )
        {
            // Reached leaf-node
            if(start == end)
                tree[index] += value;

                  else{
                    int mid = (start+end)/2;
                    if(i <=mid && i >=end)
                        pointUpdate(2*index, start, mid, i , value);
                    else
                        pointUpdate( 2*index+1, mid+1, end,  i , value);
                    tree[index] = Math.min(tree[2*index], tree[2*index+1]);
                }
                return;

            }

            static void SegmentTree(int n , int A[]) {

                tree = new int[2*n-1];

                buildTree(A, tree, 1, 0 , n-1);
            }

            public static void main(String args[])
            {
                int A[] = {1,2,3,4,5,6,7,8};
                int n = A.length;
                SegmentTree(n , A);
                for(int i =0; i < tree.length; i++) {
                    System.out.print(tree[i] + " ");

                }
                System.out.println();

                update( 1, 0, n-1, 2, 8);
                for(int i =0; i < tree.length; i++) {
                    System.out.print(tree[i] + " ");

                }
                System.out.println();
            }


        }
