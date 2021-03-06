/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        
        int left = height(root.left);
        int right = height(root.right);
        
        if(Math.abs(left - right) > 1)
            return false;
        
        boolean l = isBalanced(root.left);
        boolean r = isBalanced(root.right);
        if(!l || !r)
            return false;
        
        return true;
    }
    public int height(TreeNode root)
    {
        if(root == null)
            return 0;
        
        int left = 1 + height(root.left);
        int right = 1 + height(root.right);
        if(left == -1 || right == -1)
            return -1;
        if(Math.abs(left - right) > 1)
            return -1;
        
        return Math.max(left, right) ;
    }
}
