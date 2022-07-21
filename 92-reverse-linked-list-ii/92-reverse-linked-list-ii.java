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
    public ListNode reverseBetween(ListNode head, int left, int right)
    {
        ListNode prev = null;
        ListNode curr = head;
        int l = left;
        
        while(curr != null && l --> 1)
        {
            prev = curr;
            curr = curr.next;
        }
        ListNode firstPrev = prev;
        ListNode tail = curr;
        int length = right - left + 1;
        
        while(curr != null && length --> 0)
        {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        if(firstPrev != null)
        firstPrev.next = prev;
        
        else
            head = prev;
        
        tail.next = curr;
        
        return head;
    }
}