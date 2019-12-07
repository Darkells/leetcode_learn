package Medium;

import java.util.Stack;

/**
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 *
 *  
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 进阶:
 *
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 * 示例:
 *
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode temp = l1;
        while(temp != null) {
            stack1.push(temp.val);
            temp = temp.next;
        }
        temp = l2;
        while (temp != null) {
            stack2.push(temp.val);
            temp = temp.next;
        }

        ListNode head = null;
        //进为标识
        int flag = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || flag != 0) {
            int val = 0;
            if (!stack1.isEmpty())  val += stack1.pop();
            if (!stack2.isEmpty())  val += stack2.pop();
            val += flag;
            ListNode node = new ListNode(val % 10);
            flag = val / 10;
            node.next = head;
            head = node;
        }
        return head;
    }
}
