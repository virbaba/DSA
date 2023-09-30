import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T> 
    {
       public:
        T val;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T val) 
        {
            this.val = val;
            left = null;
            right = null;
        }
    };

************************************************************/

class Node{
    int sum = 0;
    boolean isSum;
    public Node(int sum, boolean isSum){
        this.sum = sum;
        this.isSum = isSum;
    }
}
public class Solution 
{
    public static Node betterWay(TreeNode<Integer> root){
        if(root == null)
            return new Node(0, true);
            
          if( root.left == null && root.right == null)
            return new Node(root.val, true);
            
        
        Node leftAns = betterWay(root.left);
        Node rightAns = betterWay(root.right);

        boolean left = leftAns.isSum;
        boolean right = rightAns.isSum;

        int currSum = leftAns.sum + rightAns.sum;
        boolean cond = root.val == currSum;

        Node ans = new Node(0, false);
        
        if(left && right && cond){
            ans.isSum = true;
            ans.sum = currSum + root.val;
        }
       

        return ans;

    }
    // public static int sum(TreeNode<Integer> root){
    //     if(root == null)
    //         return 0;
        
    //     int left = sum(root.left);
    //     int right = sum(root.right);

       
    //     return left + right + root.val;
    // }
    public static boolean isSumTree(TreeNode<Integer> root)
    {
        //    Write your code here.
        int sum = betterWay(root).sum;
    
        return betterWay(root).isSum;
    }
}
