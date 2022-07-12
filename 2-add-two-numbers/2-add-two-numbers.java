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
        int sum = 0;
        int carry = 0;
        ListNode ans = new ListNode(0);
        ListNode curr = ans;
        
        while(l1 != null || l2 != null)
        {
            sum = 0;
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            sum = num1 + num2 + carry;
            carry = sum / 10;
            sum = sum % 10;
            
            ListNode n = new ListNode(sum);
            curr.next = n;
            curr = curr.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
            l2 = l2.next;
        }
        if(carry > 0)
            curr.next = new ListNode(carry);
        
        return ans.next;
    }
}