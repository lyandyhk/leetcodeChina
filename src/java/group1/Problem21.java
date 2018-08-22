package group1;

import java.util.List;

public class Problem21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                curr.next = l1;
                curr = curr.next;
                l1 = l1.next;
            }
            else if(l1.val > l2.val){
                curr.next = l2;
                curr = curr.next;
                l2 = l2.next;
            }
            else{
                curr.next = l1;
                curr = curr.next;
                l1 = l1.next;
                curr.next = l2;
                curr = curr.next;
                l2 = l2.next;
            }

        }
        if(l1 == null)
            curr.next = l2;
        else
            curr.next = l1;
        return head.next;
    }
}
