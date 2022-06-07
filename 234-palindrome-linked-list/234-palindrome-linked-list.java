class Solution {
    public boolean isPalindrome(ListNode head) {
        
        if(head==null){
            return true;
        }
        
        ListNode mid=middleNode(head);
        ListNode revHead=reverse(mid);
        
        while(revHead!=null){
            if(head.val!=revHead.val){
                return false;
            }
            head=head.next;
            revHead=revHead.next;
        }
        
        return true;
    }
    
    public ListNode middleNode(ListNode head){
        
        if(head==null){
            return null;
        }
        
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        
        return slow;
    }
    
    public ListNode reverse(ListNode head){
        
        ListNode prev=null;
        ListNode curr=head;
        ListNode next=head;
        
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        
        return prev;
    }
}
