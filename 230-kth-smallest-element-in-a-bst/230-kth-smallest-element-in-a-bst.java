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
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        list = rec(root, new ArrayList<>());
        return list.get(k-1);
    }
    public ArrayList<Integer> rec(TreeNode node, ArrayList<Integer> list)
    {
        if(node == null)
        {
            return list;
        }
        rec(node.left, list);
        list.add(node.val);
        rec(node.right, list);
        return list;
    }
}