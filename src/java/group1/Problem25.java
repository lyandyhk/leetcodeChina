package group1;

/**
 * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
 *
 * 示例 :
 *
 * 给定这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 说明 :
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *
 *
 *  解答：
 *     通过锁定一个需要翻转的区间，翻转完成后进入下一个区间，如果下一个区间节点数不够k个，则不翻转，直接返回
 *     tempHead：添置的头结点
 *     before：需要翻转的区间的前一个结点，需要重新连接这个区间
 *     after：需要返还的区间的后一个结点，用来进入下一个区间，设置该指针的话将找不到下一个区间的首
 *     curr：当前需要翻转的结点
 *     next：下一个需要翻转的结点
 */
public class Problem25 {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(k<=1 || head == null)
            return head;
        ListNode tempHead = new ListNode(-1);
        tempHead.next = head;
        ListNode before = tempHead;
        ListNode after = before.next;
        ListNode curr,next;
        ListNode tail;
        while(true){
            for(int i=0;i<k;i++){
                if(after != null)
                    after = after.next;
                else
                    return tempHead.next;
            }
            curr = before.next;
            next = curr.next;
            tail = curr;
            for(int i=0;i<k;i++){
                curr.next = before.next;
                before.next = curr;
                curr = next;
                if(next == null){
                    tail.next = after;
                    return tempHead.next;
                }
                next = next.next;
            }
            tail.next = after;
            if(after == null)
                break;
            before = tail;
        }
        return tempHead.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;

        System.out.println(reverseKGroup(n1,2));
    }
}
