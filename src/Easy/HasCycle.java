package Easy;

/**
 * @author Dark
 * @date 2019/3/30 23:45
 */

/**
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 *
 * 示例 2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 *
 * 示例 3：
 *
 * 输入：head = [1], pos = -1
 * 输出：false
 * 解释：链表中没有环。
 *
 *
 *
 *
 * 进阶：
 *
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null){
            return false;
        }
        ListNode fast=head,slow=head;
        while(fast.next!=null&&fast.next.next!=null){
            //快指针
            fast=fast.next.next;
            //慢指针
            slow=slow.next;
            if(fast==slow){
                //当有环形链路的时候就可能会相等
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle01(ListNode head){
        if(head==null||head.next==null){
            return false;
        }
        if(head.next==head){
            return true;
        }
        //递归也是另外一种的快慢指针
        ListNode l=head.next;
        head.next=head;
        boolean reCycle=hasCycle(l);
        return reCycle;
    }
}
