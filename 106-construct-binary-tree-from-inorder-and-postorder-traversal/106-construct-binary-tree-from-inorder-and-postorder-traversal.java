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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i  <inorder.length; i++)
        {
            map.put(inorder[i], i);
        }
        return rec(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, map);
    }
    
    public TreeNode rec(int postorder[], int postStart, int postEnd, int inorder[], int inStart, int                                            inEnd, HashMap<Integer, Integer> map)
    {
        if(postStart > postEnd || inStart > inEnd || postEnd < 0)
            return null;
        
        TreeNode root = new TreeNode(postorder[postEnd]);
        int idx = map.get(postorder[postEnd]);
        int count = idx - inStart;
        root.left = rec(postorder, postStart, postStart + count - 1, inorder, inStart, idx - 1, map);
        root.right = rec(postorder, postStart + count, postEnd - 1, inorder, idx + 1, inEnd, map);
        return root;
        
    }
}