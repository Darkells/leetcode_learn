package Easy;

/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class ReverseList {
    public ListNode reversetList(ListNode head){
        /*//保存节点
        ListNode p = null;
        ListNode h = head;
        while (p != null){
            //临时空间
            ListNode temp = h.next;
            h.next = p;
            p = h;
            h = temp;
        }
        return p;*/
        if (head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = null;
        ListNode re = reversetList(next);
        next.next = head;
        return re;
    }
}
