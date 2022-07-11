class Solution {
public int[] nextLargerNodes(ListNode head)
{
    int count = 0;
    ListNode node = head;
    while(node != null){
        count++;
        node = node.next;
    }
    int[] ans = new int[count];
    int i = 0;
    int check = 0;
    while(head.next != null){
        ListNode temp = head.next;
        while(temp!=null){
            if(head.val < temp.val){
                ans[i] = temp.val;
                i++;
                check = 1;
                break;
            }
            temp = temp.next;
        }
        if(check == 0){
            ans[i] = 0;
            i++;
        }
        head = head.next; 
        check = 0;
    }
    ans[count-1] = 0;
   
    return ans;
}
}
