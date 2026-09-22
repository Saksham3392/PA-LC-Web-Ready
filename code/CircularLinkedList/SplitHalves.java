
public class SplitHalves {
    static class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }

    public static void splitList(Node head) {
        if (head == null || head.next == head) return;

        Node slow = head;
        Node fast = head;

        while (fast.next != head && fast.next.next != head) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast.next.next == head) {
            fast = fast.next;
        }

        Node head1 = head;
        Node head2 = slow.next;

        fast.next = slow.next;
        slow.next = head1;

        printList(head1);
        printList(head2);
    }

    public static void printList(Node head) {
        if (head == null) return;
        Node temp = head;
        do {
            System.out.print(temp.val + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = head; // Making it circular

        splitList(head);
    }
}