package Medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Dark
 * @2019/8/15 14:07
 */
public class Partition {
    public ListNode partition(ListNode head, int x) {
        Queue<ListNode> min = new LinkedList<>();
        Queue<ListNode> max = new LinkedList<>();

        while (head != null) {
            if (head.val < x) {
                min.offer(head);
            }

            if (head.val >= x) {
                max.offer(head);
            }
            head = head.next;
        }

        head = new ListNode(-1);
        ListNode foot = head;

        while (!min.isEmpty()) {
            foot.next = min.poll();
            foot = foot.next;
        }

        while (!max.isEmpty()) {
            foot.next = max.poll();
            foot = foot.next;
        }

        foot.next = null;
        return head.next;
    }
}
