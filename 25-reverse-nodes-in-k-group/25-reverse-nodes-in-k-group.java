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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(head == null || k == 1)
            return head;
        
        if(k > lengthLL(head))
            return head;
        
        int t = k;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while(curr != null && t > 0)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            t--;
        }
        head.next = reverseKGroup(curr, k);
        return prev;
    }
    public int lengthLL(ListNode head)
    {
        ListNode temp = head;
        int len = 0;
        while(temp!=null)
        {
            temp = temp.next;
            len++;
        }
        return len;
    }

}