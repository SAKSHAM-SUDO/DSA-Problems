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
class Pair
{
    TreeNode node;
    int idx;
    
    Pair(TreeNode node, int idx)
    {
        this.node = node;
        this.idx = idx;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        
        while(!q.isEmpty())
        {
            int size = q.size();
            int first = 0;
            int last = 0;
            int min = q.peek().idx;
            for(int i = 0; i < size; i++)
            {
                int currIdx = q.peek().idx - min;
                TreeNode curr = q.poll().node;
                
                if(i == 0)
                    first = currIdx;
                if(i == size - 1)
                    last = currIdx;
                
                if(curr.left != null)
                    q.add(new Pair(curr.left, currIdx * 2 + 1));
                if(curr.right != null)
                    q.add(new Pair(curr.right, currIdx * 2 + 2));
            }
            ans = Math.max(ans, last - first + 1);
        }
        return ans;
    }
}