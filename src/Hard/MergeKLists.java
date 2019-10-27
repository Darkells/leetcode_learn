package Hard;

import Medium.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> q = new PriorityQueue<>(Comparator.comparing(node -> node.val ));
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                q.add(lists[i]);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!q.isEmpty()) {
            tail.next = q.poll();
            tail = tail.next;
            if (tail.next != null) {
                q.add(tail.next);
            }
        }
        return dummy.next;
    }
}
