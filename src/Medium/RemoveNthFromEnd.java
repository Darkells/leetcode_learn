package Medium;

/**
 * @author Dark
 * @2019/7/29 14:16
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 1;
        ListNode temp = head;
        while (temp.next != null) {
            size++;
            temp = temp.next;
        }
        size -= n;
        temp = head;
        if (size == 0) {
            return new ListNode();
        }


        while (size > 0) {
            size--;
            temp = temp.next;
        }

        if (n == 1) {
            temp.next = null;
        }else {
            temp.next = temp.next.next;
        }

        return head;
    }
}
