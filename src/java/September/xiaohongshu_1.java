package September;


import java.util.Scanner;



public class xiaohongshu_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] nums = str.split(" ");
        int k = sc.nextInt();
        ListNode head = new ListNode(-1);
        ListNode currNode = head;
        for(String s : nums){
            int curr = Integer.valueOf("" + s);
            ListNode node = new ListNode(curr);
            currNode.next = node;
            currNode = node;
        }

        head = reverseK(head.next,k);
        StringBuilder sb = new StringBuilder();
        while(head != null){
            sb.append(" "+head.val);
            head = head.next;
        }
        System.out.println(sb.toString().trim());
    }
    public static ListNode reverseK(ListNode head, int k) {
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
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
