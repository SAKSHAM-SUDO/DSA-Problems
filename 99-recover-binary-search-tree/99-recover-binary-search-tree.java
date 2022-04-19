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
    TreeNode firstMistake = null, secondMistake = null, prev = null;
    public void recoverTree(TreeNode root) {
        helper(root);
        swap(firstMistake, secondMistake);
    }
    void swap(TreeNode a,TreeNode b)
    {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
    void helper(TreeNode root)
    {
        if(root == null)
            return ;
        helper(root.left);
        
        if(prev!=null &&  prev.val > root.val)
        {
            if(firstMistake == null)
            {
                firstMistake = prev;
            }
            secondMistake = root;
        }
         
        prev = root;
        helper(root.right);
    }
}