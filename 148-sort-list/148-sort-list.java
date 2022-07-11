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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode mid = getMid(head);
        ListNode firstHalf = sortList(head);
        ListNode secondHalf = sortList(mid);
        return merge(firstHalf, secondHalf);
    }
    public ListNode merge(ListNode list1, ListNode list2)
    {
        ListNode dummy = new ListNode();
        ListNode d = dummy;
        while(list1 != null && list2 != null)
        {
            if(list1.val < list2.val)
            {
                d.next = list1;
                list1 = list1.next;
                d = d.next;
            }
            else
            {
                d.next = list2;
                list2 = list2.next;
                d = d.next;
            }
        }
        d.next = (list1 != null) ? list1 : list2;
        return dummy.next;
    }
     ListNode getMid(ListNode head) {
        ListNode midPrev = null;
        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }
}