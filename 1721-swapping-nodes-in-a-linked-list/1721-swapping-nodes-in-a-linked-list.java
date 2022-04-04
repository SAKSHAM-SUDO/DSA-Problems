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
    public ListNode swapNodes(ListNode head, int k) {
        if(head.next == null)
        {
            return head;
        }
        int size = getSize(head);
        int idx1 = k;
        int idx2 = size - k + 1;
        int i = 1;
        ListNode firstNode = head;
        ListNode secondNode = head;
        while(i != idx1)
        {
            firstNode = firstNode.next;
            i++;
        }
        i = 1;
        while(i != idx2)
        {
            secondNode = secondNode.next;
            i++;
        }
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
        return head;
    }
    public int getSize(ListNode head)
    {
        int size = 1;
        while(head != null && head.next != null)
        {
            head = head.next;
            size++;
        }
        return size;
    }
}