class Pair
{
    TreeNode node;
    int lvl;
    Pair(TreeNode node, int lvl)
    {
        this.node = node;
        this.lvl = lvl;
    }
}
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty())
        {
            Pair pair = q.poll();
            TreeNode node = pair.node;
            int lvl = pair.lvl;
            
            if(map.containsKey(lvl))
            {
                map.put(lvl, node.val);
            }
            else
                map.put(lvl, node.val);
            
            if(node.left != null)
                q.add(new Pair(node.left, lvl + 1));
            if(node.right != null)
                q.add(new Pair(node.right, lvl + 1));
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            list.add(entry.getValue());
        }
        return list;
    }
}