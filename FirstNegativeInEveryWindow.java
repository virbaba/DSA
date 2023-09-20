/* TIME COMPLEXITY O(N) 
  SPACE COMPLEXITY O(K)
*/

/*
    Time Complexity: O(N)
    Space Complexity: O(K)

    Where N is the size of the given array and K is the size of the window.
*/

import java.util.Queue;
import java.util.LinkedList;

public class Solution {
    public static int[] firstNegative(int arr[], int n, int k) {
        int[] ans = new int[n - k + 1];
        int inx = 0;

        Queue<Integer> q = new LinkedList<>();
        
        // firstly we find the all negative integer in first window
        // and storing indexing into queue
        for(int i = 0; i < k; i++){
            if(arr[i] < 0)
                q.add(i);
        }

        int start = 0 , end = k - 1;

        // jab tak chalo jab tak end less than end hai
        while(end < n){
            // firstly i check q is empty or not if empty mean
            // no negative integer in first window
            if(!q.isEmpty()){
                int currIndex = q.peek();
                ans[inx++] = arr[currIndex];
                
                // if start == currIndex mean negative integer in
                // curr window is not use in next window
                if(start == currIndex)
                    q.poll();
            }
            else{
                ans[inx++] = 0;
            }
            start++;
            end++;

            if(end < n && arr[end] < 0)
                q.add(end);
        }

        return ans;
    }

}
