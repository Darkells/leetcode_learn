package Easy;

/**
 * @author Dark
 * @date 2019/5/21 9:02
 */

/**
 *
 */
public class MyLinkedList {
    ListNode head;
    int length;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        length = 0;
        head = new ListNode(-1);
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index >= length || index < 0){
            return -1;
        }
        ListNode temp = head;
        for (int i = 0 ; i < length; i++){
            temp = temp.next;
        }
        return temp.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode temp = new ListNode(val);
//        temp.next = head.next;
//        head.next = temp;
//        head = new ListNode(val,head);
        temp.next = head;
        head = temp;
        length++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        ListNode temp2 = new ListNode(val);
        temp.next = temp2;
        length++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > length)
            return;
        if(index == length){
            addAtTail(val);
            return;
        }
        if(index < 0)
            index = index+length+1;
        ListNode current = head;
        for(int i = 0; i < index; i++)
            current = current.next;
        ListNode ptr = current.next;
        ListNode temp = new ListNode(val);
        current.next = temp;
        temp.next = ptr;
        length ++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index >= length || index < 0)
            return;
        ListNode current = head;
        for(int i = 0; i < index; i++)
            current = current.next;
        current.next = current.next.next;
        length --;
    }

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }

        public ListNode(int val,ListNode next){
            this.val = val;
            this.next = next;
        }
    }
}
