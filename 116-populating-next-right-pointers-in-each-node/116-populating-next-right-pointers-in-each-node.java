/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) {
            return root;
        }
        Deque<Node> queue = new ArrayDeque<>();
        queue.addLast(root);
        while(!queue.isEmpty()) {
            int nodes = queue.size();
            List<Node> level = new ArrayList<>();
            while(nodes > 0) {
                Node currNode = queue.pollFirst();
                level.add(currNode);
                nodes --;
                if(currNode.left != null) {
                    queue.addLast(currNode.left);
                }
                if(currNode.right != null) {
                    queue.addLast(currNode.right);
                }
            }
            Node next = null;
            for(int i = level.size() - 1; i >= 0; i --) {
                Node curr = level.get(i);
                curr.next = next;
                next = curr;
            }
        }
        return root;
    }
}