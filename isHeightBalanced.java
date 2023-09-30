/*************************************************************

     Following is thr TreeNode class structure

     class BinaryTreeNode<T>
     {
         T data;
         BinaryTreeNode<T> left;
         BinaryTreeNode<T> right;

         BinaryTreeNode(T data) {
             this.data = data;
             left = null;
             right = null;
         }
     };

 *************************************************************/
 class Node{
     int height;
     boolean isBal;
     Node(int height, boolean isBal){
         this.height = height;
         this.isBal = isBal;
     }
 }
public class Solution {
    public static Node checkInBetterWay(TreeNode<Integer> root){
        if(root == null)
            return new Node(0, true);

        Node leftAns = checkInBetterWay(root.left);
        Node rightAns = checkInBetterWay(root.right);

        boolean left = leftAns.isBal;
        boolean right = rightAns.isBal;
        boolean con = Math.abs(leftAns.height - rightAns.height) <= 1;
        boolean isBal = false;


        if(left && right && con)
            isBal = true;

        int height =  1 + Math.max(leftAns.height, rightAns.height);

        return new Node(height, isBal);
    }
    // public static int height(TreeNode<Integer> root){
    //     if(root == null)
    //         return 0;
        
    //     return 1 + Math.max(height(root.left), height(root.right));
    //     if(root == null)
    //         return true;
        
    //     boolean left = isBalancedBT(root.left);
    //     boolean right = isBalancedBT(root.right);
        
          // boolean ans = left && right;
    //    if(Math.abs(height(root.left) - height(root.right))  > 1)
    //     ans = false;

    //     return ans;
    // }
    public static boolean isBalancedBT(TreeNode<Integer> root) {
        // Write your code here.
        
        return checkInBetterWay(root).isBal;
    }
}
