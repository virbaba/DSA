import java.util.* ;
import java.io.*; 
public class Solution 
{
  public static Queue<Integer> reverseElements(Queue<Integer> q, int k) 
  {
    // Write your code here.
    Stack<Integer> st = new Stack<>();
        int n = q.size();
        int r = n - k;
        
        while(k != 0){
            st.push(q.poll());
            k--;
        }
        
        while(!st.empty()){
            q.offer(st.pop());
        }
        
        while(r != 0){
            q.offer(q.poll());
            r--;
        }
        
        return q;
  }
}
