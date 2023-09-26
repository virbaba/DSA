import java.util.* ;
import java.io.*;

public class Solution {
    public static long sumOfMaxAndMin(ArrayList<Integer> nums, int n, int k) {
        // Write your code here.
        if(n == 1){
            return nums.get(0) + nums.get(0);
        }
        ArrayList<Integer> max = new ArrayList<>();
        ArrayList<Integer> min = new ArrayList<>();

        Deque<Integer> q = new LinkedList<>();

        int start = 0, end = 0;
        while(end < n){
            while(!q.isEmpty() && nums.get(q.getLast()) < nums.get(end)){
                q.removeLast();
            }
            q.addLast(end);

            if(end-start < k)
                end++;
            if(end-start == k){
                max.add(nums.get(q.getFirst()));
                if(q.getFirst() == start)
                    q.removeFirst();

                start++;
            }
        }
       // System.out.println(max);

         q = new LinkedList<>();
        start = 0; end = 0;
        while(end < n){
            while(!q.isEmpty() && nums.get(q.getLast()) > nums.get(end)){
                q.removeLast();
            }
            q.addLast(end);

            if(end-start < k)
                end++;
            if(end-start == k){
                min.add(nums.get(q.getFirst()));
                if(q.getFirst() == start)
                    q.removeFirst();

                start++;
            }
        }
       // System.out.println(min);

        long minSum = 0;
        long maxSum = 0;

        for(int i = 0; i < min.size(); i++){
            minSum += min.get(i);
            maxSum += max.get(i);
        }

        return minSum + maxSum;

    }
}
