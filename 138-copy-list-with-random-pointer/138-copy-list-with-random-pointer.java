/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)
        {
            return head;
        }
        Node curr = head;
        
        while(curr != null)
        {
            Node node = new Node(curr.val);
            node.next = curr.next;
            curr.next = node;
            curr = curr.next.next;
        }
        curr = head;
        while(curr != null)
        {
            curr.next.random = curr.random != null ? curr.random.next : null;
            curr = curr.next.next;
        }
        
        Node orig = head;
        Node copy = head.next;
        Node t = copy;
        while(orig != null)
        {
            orig.next = orig.next.next;
            t.next = t.next != null ? t.next.next : null;
            orig = orig.next;
            t = t.next;
        }
        return copy;
    }
}