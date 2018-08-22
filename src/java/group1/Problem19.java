package group1;

/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 *
 *
 *
 * 解答：双指针，时间复杂度O(n)
 */
public class Problem19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        //辅助链表头，因为如果要删除的是head的话代码将不适用
        ListNode tempHead = new ListNode(-1);
        tempHead.next = head;
        ListNode sen = tempHead;
        ListNode curr = tempHead;
        for(int i=0;i<n;i++){
            sen = sen.next;
        }
        while(sen.next != null){
            curr = curr.next;
            sen = sen.next;
        }
        curr.next = curr.next.next;

        return tempHead.next;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */