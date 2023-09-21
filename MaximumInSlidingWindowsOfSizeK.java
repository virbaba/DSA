import java.util.* ;
import java.io.*;

public class Solution 
{

	public static ArrayList<Integer> getMaximumOfSubarrays(ArrayList<Integer> nums, int k) 
	{
		//	  Write your code here.
		ArrayList<Integer> ans = new ArrayList<>();
		Deque<Integer> q = new LinkedList<>();
		int start = 0, end = 0, n = nums.size();

		while(end < n){
			while(!q.isEmpty() && nums.get(q.getLast()) < nums.get(end)){
				q.removeLast();
			}
			q.addLast(end);

			if(end - start < k - 1){
				end++;
			}
			else if(end - start == k - 1){
				ans.add(nums.get(q.getFirst()));
				if(q.getFirst() == start)
					q.removeFirst();
				
				start++;
				end++;
			}
		}
		return ans;
	}
}
