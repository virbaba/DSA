/************************************************************
TIME COMPLEXITY: O(N)
SPACE COMPLEXITY: O(N)

 Following is the Binary Tree node structure:
 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;

     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
 }

 ************************************************************/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // left part
    public static void leftPart(TreeNode root, List<Integer> ans){
        if(root == null || (root.left == null && root.right == null)){
            return;
        }
        ans.add(root.data);
        if(root.left == null && root.right != null)
            leftPart(root.right, ans);

        leftPart(root.left, ans);

    }

    // leaf part
    public static void leaf(TreeNode root, List<Integer> ans){
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            ans.add(root.data);

        leaf(root.left, ans);
        leaf(root.right, ans);
    }

    // right part
    public static void rightPart(TreeNode root, List<Integer> ans){
         if(root == null || (root.left == null && root.right == null)){
            return;
        }
        
        rightPart(root.right, ans);
        
        if(root.right == null && root.left != null){
            rightPart(root.left, ans);
        }
        ans.add(root.data);

    }
    public static List<Integer> traverseBoundary(TreeNode root){
        // Write your code here.
        List<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;

        ans.add(root.data);

        leftPart(root.left, ans);
        leaf(root, ans);
        rightPart(root.right, ans);

        return ans;
    }
}
