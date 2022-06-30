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
    ArrayList<TreeNode> list;
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        list = new ArrayList<>();
        dfs(root);
        
        TreeNode curr = list.get(0);
        
        for(int i = 1; i < list.size(); i++)
        {
            TreeNode next = list.get(i);
            curr.left = null;
            curr.right = next;
            curr = next;
        }
        
    }
    public void dfs(TreeNode root)
    {
        if(root == null)
            return;
        
        list.add(root);
        dfs(root.left);
        dfs(root.right);
    }
}