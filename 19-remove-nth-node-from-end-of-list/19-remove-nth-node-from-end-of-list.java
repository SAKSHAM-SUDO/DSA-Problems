/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        if(head == null && n == 0 )
        {
            return null;
        }
        if(head.next == null && n == 1)
        {
            return null;
        }
        if(head.next == null && n == 0)
        {
            return head;
        }
        int size = getSize(head);
        if(size == n)
        {
            head = head.next;
            return head;
        }

        int deleteIndex = size - n;
        ListNode curr = head;
        ListNode prev = head;
        
        while(deleteIndex != 0)
        {
            deleteIndex--;
            prev = curr;
            curr = curr.next;
        }
        prev.next = curr.next;
        return head;
    }
    public int getSize(ListNode node)
    {
        int size= 0;
        
        while(node != null)
        {
            size++;
            node = node.next;
        }
        return size;
    }
}