package Medium;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;

        if (head.val == next.val) {
            while (next != null && head.val == next.val) {
                next = next.next;
            }

            head = deleteDuplicates(next);
        }

        else {
            head.next = deleteDuplicates(next);
        }
        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode res = new ListNode(0);
        res.next = head;

        //创建双指针
        ListNode cur = head;
        ListNode last = res;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                int val = cur.val;
                while (cur != null && cur.val == val) {
                    cur = cur.next;
                }
                last.next = cur;
            }

            else {
                last = cur;
                cur = cur.next;
            }
        }

        return res.next;
    }
}
