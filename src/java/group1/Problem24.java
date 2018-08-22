package group1;


/**
 *
 *
 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

 示例:

 给定 1->2->3->4, 你应该返回 2->1->4->3.
 说明:

 你的算法只能使用常数的额外空间。
 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。




 解答：
             情况1：如果某时刻不存在奇偶成对的情况，则不交换
             情况2：奇偶成对的情况，交换两者

             1.用三个指针，curr指针指向当前的奇数节点，after指向下一个奇数节点，before指向当前奇数节点的前一个节点
             2.调换curr和curr的下一个节点，并将这两个节点的前后连接起来后，将before指向curr，curr指向before下一个，after指向curr的下一个的下一个
             3.结束条件为after为null或者after.next为null，因为after.next如果为null，那就说明接下来只有一个节点了，不需要调换位置了


 */
public class Problem24 {
    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode tempHead = new ListNode(-1);
        tempHead.next = head;
        ListNode k = tempHead;
        ListNode before = k,curr = k.next,after = k.next.next.next;
        while(true){
            ListNode temp = curr.next;
            temp.next = curr;
            before.next = temp;
            curr.next = after;
            if(after == null || after.next == null)
                break;
            else {
                before = curr;
                curr = before.next;
                after = curr.next.next;
            }
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
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        System.out.println(swapPairs(n1));
    }
}
