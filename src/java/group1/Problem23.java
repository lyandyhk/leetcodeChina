package group1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Problem23 {
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(-1);
        Arrays.sort(lists, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if(o1.val<o2.val)
                    return -1;
                else if(o1.val>o2.val)
                    return 1;
                else
                    return 0;
            }
        });
        return new ListNode(1);
    }

    public static void main(String[] args) {

    }
}
