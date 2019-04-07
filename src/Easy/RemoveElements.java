package Easy;

/**
 *
 */
public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        if (head.val == val) {
            return removeElements(head.next, val);
        } else {
            head.next = removeElements(head.next, val);
        }
        return head;
    }

    public static ListNode removeElments2(ListNode head, int val){
        ListNode header = new ListNode(-1);
        header.next = head;
        ListNode cur = header;
        while(cur.next != null){
            if(cur.next.val == val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        System.out.println(head);
        System.out.println(header);
        return header.next;
    }

    public static void main(String args[]){
    }
}
