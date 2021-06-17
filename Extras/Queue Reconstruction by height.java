/*Queue Reconstruction by height

Algorithm:
First sort all the ppl in decreasing order of their height.For those who have same height,sort 
them in ascending order of their k-values.
Now simply iterate over the sorted array and insert them in kth index in the output array.
 
Why is this working?
Consider the current person being inserted in the output array. As he is the smallest person being inserted
(as previously inserted people will be taller) , we will simply insert him at his kth position(which will
work as all of them are taller than him). Now since his height is less than already inserted people his 
positioning won't effect the kth value for previously inserted people.
  
 
 
 */
 class Solution{
    public int[][] reconstruct queue(int[][] people)
	{
	Arrays.sort(people, (a,b) -> a[0] == b[0] ? a[1]-b[1] : b[0] - a[0]);
	ArrayList<int[]> result = new ArrayList<>();
	for(int[] p : people)
	result.add(p[1] , p);
	
	int n = people.length;
	return result.toArray(new int[n][2]);
	}
	
	
	}
	