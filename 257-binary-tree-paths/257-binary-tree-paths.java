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
    ArrayList<String> list = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        path(root, "");
        return list;
    }
    public void path(TreeNode root, String path)
    {
        if(root == null)
            return;
        
        if(root.left == null && root.right == null)
        {
            path = path + Integer.toString(root.val);
            list.add(path);
            return;
        }
        path = path + Integer.toString(root.val);
        path(root.left, path + "->");
        path(root.right, path + "->");
    }
}