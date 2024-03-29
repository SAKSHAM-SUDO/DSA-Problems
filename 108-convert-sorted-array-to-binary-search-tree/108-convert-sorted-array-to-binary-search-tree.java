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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0)
            return null;
        
        return convert(nums, 0, nums.length - 1);
    }
    
    public TreeNode convert(int nums[], int start, int end)
    {
        if(start > end)
            return null;
        
        int mid = start + (end - start) / 2;
        TreeNode midNode = new TreeNode(nums[mid]);
        
        midNode.left = convert(nums, start, mid - 1);
        midNode.right = convert(nums, mid + 1, end);
        
        return midNode;
    }
}