package test;

import Medium.ListNode;
import Medium.ReorderList;

public class test {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ReorderList.reorderList(head);
    }
}
