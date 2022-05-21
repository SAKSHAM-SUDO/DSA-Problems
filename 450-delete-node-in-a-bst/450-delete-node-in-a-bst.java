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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;
        
        if(root.val == key)
        {
            return connection(root);
        }
        TreeNode curr = root;
        
        while(root != null)
        {
            if(key < root.val)
            {
                if(root.left != null && root.left.val == key)
                {
                    root.left = connection(root.left);
                }
                else
                {
                    root = root.left;
                }
            }
            else
            {
                if(root.right != null && root.right.val == key)
                {
                    root.right = connection(root.right);
                }
                else
                {
                    root = root.right;
                }
            }
        }
        return curr;
    }
    public TreeNode connection(TreeNode node)
    {
        if(node.left == null)
            return node.right;
        else if(node.right == null)
            return node.left;
        
        TreeNode rightSubTree = node.right;
        TreeNode lastRight = findLastRight(node.left);
        lastRight.right = rightSubTree;
        
        return node.left;
    }
    public TreeNode findLastRight(TreeNode node)
    {
        if(node.right == null)
            return node;
        else
            return findLastRight(node.right);
    }
}