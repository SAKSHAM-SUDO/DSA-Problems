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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        check(p, q);
        return flag;
    }
    public void check(TreeNode p, TreeNode q)
    {
        if(p == null && q == null)
            return;
        else if((p == null && q != null) || (p != null && q == null))
        {
            flag = false;
            return;
        }
        if(p.val != q.val)
        {
            flag = false;
            return;
        }
            
        isSameTree(p.left, q.left);
        isSameTree(p.right, q.right);

    }
}