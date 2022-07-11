/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node curr = head;
        
        while(curr != null)
        {
            if(curr.child != null)
            {
                Node childHead = curr.child;
                Node childTail = curr.child;
                while(childTail.next != null)
                {
                    childTail = childTail.next;
                }
                childTail.next = curr.next;
                if(curr.next != null)
                curr.next.prev = childTail;
                
                childHead.prev = curr;
                curr.next = childHead;
                curr.child = null;
                
            }
            else
                curr = curr.next;
        }
        return head;
    }
}