package group1;

/**
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Problem2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int flag = 0;
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        while(l1!=null || l2!=null){
            int val1 = 0;
            int val2 = 0;
            if(l1 != null){
                val1 = l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                val2 = l2.val;
                l2 = l2.next;
            }
            int sum = val1 + val2 + flag;
            flag = 0;
            if(sum >= 10){
                flag = 1;
                sum = sum - 10;
            }
            curr.next = new ListNode(sum);
            curr = curr.next;

        }
        if(flag == 1){
            curr.next = new ListNode(1);
            curr = curr.next;
        }
        head = head.next;
        if(head == null)
            return null;
        return head;
    }
}
/*
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
*/