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
        ArrayList<Integer> list = new ArrayList<>();
        dfs(root, 0, list);
        return list;
    }
    public void dfs(TreeNode curr, int level, ArrayList<Integer> list)
    {
        if(curr == null)
            return;
        if(list.size() == level)
            list.add(curr.val);
        
        dfs(curr.right, level + 1, list);
        dfs(curr.left, level + 1, list);
    }
}