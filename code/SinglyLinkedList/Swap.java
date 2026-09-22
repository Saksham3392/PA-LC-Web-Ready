package SinglyLinkedList;

public class Swap {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    public ListNode swapNodes(ListNode head, int k) {
        ListNode first = head;
        for (int i = 1; i < k; i++) {
            first = first.next;
        }

        ListNode second = head;
        ListNode temp = first;

        while (temp.next != null) {
            temp = temp.next;
            second = second.next;
        }

        int val = first.val;
        first.val = second.val;
        second.val = val;

        return head;
    }
}
