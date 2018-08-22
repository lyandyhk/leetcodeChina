package group1;

import java.util.*;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * 解答：多个链表同时排，取首个，然后取其next，如果next为null，那么将其设为MAX_INT
 */

public class Problem23 {
    public static ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> nodeList = new ArrayList<>();
        for(ListNode node : lists){
            if(node != null)
                nodeList.add(node);
        }
        if(nodeList.size() == 0)
            return null;
        ListNode maxNode = new ListNode(Integer.MAX_VALUE);
        ListNodeComparator comparator = new ListNodeComparator();
        Collections.sort(nodeList, comparator);
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        while(nodeList.size()>0){
            ListNode first = nodeList.get(0);
            curr.next = first;
            curr = curr.next;
            if(first.next != null){
                nodeList.set(0,first.next);
                Collections.sort(nodeList, comparator);
            }
            else{
                if(nodeList.size()>1)
                    nodeList = nodeList.subList(1,nodeList.size());
                else
                    break;
            }

        }
        return head.next;
    }

}
class ListNodeComparator implements Comparator<ListNode>{
    @Override
    public int compare(ListNode o1, ListNode o2) {
        if(o1.val<o2.val)
            return -1;
        else if(o1.val>o2.val)
            return 1;
        else
            return 0;
    }
}