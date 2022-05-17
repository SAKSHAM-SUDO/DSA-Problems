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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        
        List<List<Integer>> list = new ArrayList<>();
        int lvl = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size() != 0)
        {
            List<Integer> ll = new ArrayList<>();
            Stack<Integer> st = new Stack<>();
            int size = q.size();
            for(int i = 0; i < size; i++)
            {
                TreeNode curr = q.poll();
                if(lvl % 2 == 1)
                {
                    st.push(curr.val);
                }
                else
                {
                    ll.add(curr.val);
                }
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            while(!st.isEmpty())
            {
                ll.add(st.pop());
            }
            list.add(new ArrayList<>(ll));
            lvl++;
        }
        return list;
    }
}