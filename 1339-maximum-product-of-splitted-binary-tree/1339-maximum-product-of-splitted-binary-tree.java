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
// class Solution {
//     long totalSum = 0;
//     long maxSum = 0;
//     public int maxProduct(TreeNode root) {
//         sum(root);
//         calc(root);
//         return (int)(maxSum % (int)(Math.pow(10, 9) + 7));
//     }
//     public void sum(TreeNode node)
//     {
//         if(node == null)
//             return;
//         sum(node.left);
//         sum(node.right);
//         totalSum += (long)node.val;
//     }
//     public long calc(TreeNode node)
//     {
//         if(node == null)
//             return 0;
//         long left = calc(node.left);
//         long right = calc(node.right);
//         long curr = left + right + node.val;
//         maxSum = Math.max(maxSum, (totalSum - curr) * (curr));
//         return maxSum;
//     }
        
// }
class Solution {
    private long totalSum = 0 ;
    private long maxProd = 0;

    public int maxProduct(TreeNode root) {
        dfs(root);
        calculateSubTreeSum(root);
        return (int)(maxProd % ((int)Math.pow(10, 9) + 7));
    }

    public  void dfs(TreeNode root) {
        if(root == null) return;
        dfs(root.left);
        dfs(root.right);

        totalSum += (long)root.val;
    }
    public  long calculateSubTreeSum(TreeNode root) {
        if(root == null) return 0;
        long l = calculateSubTreeSum(root.left);
        long r = calculateSubTreeSum(root.right);
        long subTreeSum = l + r + root.val;
        maxProd = Math.max(maxProd, (subTreeSum) * (totalSum - subTreeSum));
        return subTreeSum;
    }

}
