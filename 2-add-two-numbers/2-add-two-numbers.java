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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        int sum = 0;
        ListNode dhead = new ListNode(0);
        ListNode curr = dhead;
        while(l1 != null || l2 != null)
        {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            sum = x + y + carry;
            carry = sum / 10;
            sum = sum % 10;
            
            curr.next = new ListNode(sum);
            curr = curr.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
            l2 = l2.next;
        }
        if(carry > 0)
            curr.next = new ListNode(carry);
        // ListNode rev = reverse(temp);
        return dhead.next;
    }
}