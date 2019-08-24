package Medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Connect2 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node pre = null;
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if (i > 0) {
                    pre.next = cur;
                }

                pre = cur;
                if (cur.left != null) {
                    queue.offer(cur.left);
                }

                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }

        return root;
    }

    public Node connect2(Node root) {
        Node cur = root;
        while (cur != null) {
            Node dummy = new Node();
            //这里经常对链表或者二叉树原地操作使用的方法
            Node tail = dummy;
            //当层cur遍历
            while (cur != null) {
                if (cur.left != null) {
                    //操作之后，dumy -> cur.left
                    tail.next = cur.left;
                    tail = tail.next;
                }

                if (cur.right != null) {
                    tail.next = cur.right;
                    tail = tail.next;
                }
                cur = cur.next;
            }
            //更新到cur的下一层
            cur = dummy.next;
        }

        return root;
    }
}
