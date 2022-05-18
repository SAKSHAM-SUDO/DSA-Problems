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
class Struct
{
    TreeNode node;
    int vertical;
    int lvl;
    Struct(TreeNode node, int vertical, int lvl)
    {
        this.node = node;
        this.vertical = vertical;
        this.lvl = lvl;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Struct> q = new LinkedList<>();
        int vertical = 0;
        int lvl = 0;
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        q.add(new Struct(root, 0, 0));
        while(!q.isEmpty())
        {
                Struct curr = q.poll();
                TreeNode currNode = curr.node;
                int x = curr.vertical;
                int y = curr.lvl;
                
                if(!map.containsKey(x))
                {
                    map.put(x, new TreeMap<>());
                }
                if(!map.get(x).containsKey(y))
                {
                    map.get(x).put(y, new PriorityQueue<>());
                }
                
                map.get(x).get(y).offer(currNode.val);
                
                if(currNode.left != null)
                {
                    q.offer(new Struct(currNode.left, x - 1, y + 1));
                }
                if(currNode.right != null)
                {
                    q.offer(new Struct(currNode.right, x + 1, y + 1));
                }
        }
            List<List<Integer>> list = new ArrayList<>();
            for(TreeMap<Integer, PriorityQueue<Integer>> ys : map.values())
            {
                list.add(new ArrayList<>());
                for(PriorityQueue<Integer> nodes : ys.values())
                {
                    while(!nodes.isEmpty())
                    {
                        // System.out.println(nodes.peek());
                        list.get(list.size() - 1).add(nodes.poll());
                    }
                }
            }
        return list;
    }
}