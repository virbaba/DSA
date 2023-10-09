/*
  in this question we compare the level and sum of root to leaf node if previous level is less than to current level then we store current level and sum also and if both
  level is equall then we compare the sum and greate sum is stored 
*/
class Solution{
    public void solve(Node root, Queue<Integer> level, Queue<Integer> data, int l, int sum){
         if(root == null){
            //System.out.println(sum);
            int lvl = level.poll();
            int value = data.poll();
            if(l > lvl){
                level.offer(l);
                data.offer(sum);
            }
            else if(l == lvl){
                level.offer(lvl);
                if(sum > value){
                    data.offer(sum);
                }
                else{
                    data.offer(value);
                }
            }
            else
            {
                level.offer(lvl);
                data.offer(value);
            }
            return;
         }
       
      
        sum += root.data;
        solve(root.left, level, data, l+1, sum);
        solve(root.right, level, data, l+1, sum);
            
        
    }
    public int sumOfLongRootToLeafPath(Node root)
    {
        //code here
        Queue<Integer> level = new LinkedList<>();
        Queue<Integer> data = new LinkedList<>();
        level.offer(0);
        data.offer(0);
        
        solve(root, level, data, 0, 0);
        return data.poll();
        
    }
}
