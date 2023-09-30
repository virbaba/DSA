/*************************************************************

 Following is the Binary Tree Node structure:

 class TreeNode<T> {
     public T data;
     public BinaryTreeNode<T> left;
     public BinaryTreeNode<T> right;

     TreeNode(T data) {
         this.data = data;
         left = null;
         right = null;
     }
 }

 *************************************************************/
class Node{
	int dia,height;
	public Node(int dia, int height){
		this.dia = dia;
		this.height = height;
	}
}
public class Solution {

    public static Node solve(TreeNode<Integer> root){
		if(root == null){
			return new Node(0, 0);
		}

		Node left = solve(root.left);
		Node right = solve(root.right);

		int leftDia = left.dia;
		int rightDia = right.dia;
		int bothDia = 1 + left.height + right.height;

		Node ans = new Node(0, 0);
		ans.dia = Math.max(leftDia, Math.max(rightDia, bothDia));
		ans.height = 1 + Math.max(left.height, right.height);

		return ans;
	}
    public static int diameterOfBinaryTree(TreeNode<Integer> root) {
        // Write your code here.
        return solve(root).dia - 1 ;
    }
}
