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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        func(root, 0, list);
        return list;
    }
    public void func(TreeNode node, int level, List<Integer> list)
    {
        if(node == null)
            return;
        if(level == list.size())
            list.add(node.val);
        
        func(node.right, level + 1, list);
        func(node.left, level + 1, list);
    }
    
}