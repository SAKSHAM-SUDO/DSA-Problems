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
    public ListNode swapPairs(ListNode head) {
        if(head == null)
        {
            return null;
        }
        
        int c = 0;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        
        while(curr != null && c < 2)
        {
            c++;
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head.next = swapPairs(next);
        return prev;
    }
}