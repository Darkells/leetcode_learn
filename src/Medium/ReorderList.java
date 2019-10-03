package Medium;

import java.util.HashMap;
import java.util.List;

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReorderList {
    public static void reorderList(ListNode head) {
        HashMap<Integer, ListNode> map = new HashMap<>();
        int count = 0;
        ListNode pre = head;
        while (pre != null) {
            map.put(count,pre);
            pre = pre.next;
            count++;
        }
        int size = count;
        count = 0;

        for (int i = 0; i < size; i++) {
            if (i == 0) {
                pre = head;
                System.out.println(head.val);
                continue;
            } else if (i % 2 == 0) {
                head.next = map.get(count);
            } else {
                head.next = map.get(size - 1 - count);
                count++;
            }
            head = head.next;
        }
        head.next = null;
        head = pre;
    }
}
