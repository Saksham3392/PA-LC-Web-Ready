package SinglyLinkedList;

public class InsertionSortList {
    static class ListNode {
        int data;
        ListNode next;
        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;

        ListNode dummy = new ListNode(0);
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            ListNode prev = dummy;

            while (prev.next != null && prev.next.data < curr.data) {
                prev = prev.next;
            }

            curr.next = prev.next;
            prev.next = curr;
            curr = next;
        }

        return dummy.next;
    }
}
