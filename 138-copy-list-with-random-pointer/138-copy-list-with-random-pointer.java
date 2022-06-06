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
        // while(curr != null)
        // {
        //     Node temp = new Node(curr.val);
        //     temp.next = curr.next;
        //     curr.next = temp;
        //     curr = curr.next.next;
        // }
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
        Node temp = head.next;
        Node dup = temp;
        while(orig != null)
        {
            orig.next = orig.next.next;
            dup.next = dup.next != null ? dup.next.next : null;
            orig = orig.next;
            dup = dup.next;
        }

        return temp;
    }
}