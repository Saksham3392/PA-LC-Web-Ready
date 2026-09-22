package SinglyLinkedList;

public class Cyclell {
    static class ListNode {
        int data;
        ListNode next;
        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                ListNode temp = head;
                while (temp != slow) {
                    slow = slow.next;
                    temp = temp.next;
                }
                return temp;
            }
        }

        return null;
    }
}
