package Easy;

public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null){
            return true;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = reverseList(slow.next);
        while (slow != null){
            if (head.val != slow.val){
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head) {
        // //保存节点
        // ListNode p = null;
        // ListNode h = head;
        // while (h != null){
        //     //临时空间
        //     ListNode temp = h.next;
        //     h.next = p;
        //     p = h;
        //     h = temp;
        // }
        // return p;
        if (head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = null;
        ListNode re = reverseList(next);
        next.next = head;
        return re;
    }
}
