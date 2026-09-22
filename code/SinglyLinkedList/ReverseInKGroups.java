package SinglyLinkedList;

public class ReverseInKGroups {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node reverseKGroup(Node head, int k) {
        Node curr = head;
        Node prev = null;
        Node next = null;
        int count = 0;

        // Check if there are at least k nodes left
        Node temp = head;
        for (int i = 0; i < k; i++) {
            if (temp == null) return head;
            temp = temp.next;
        }

        // Reverse first k nodes
        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        // Recursively reverse remaining groups
        if (next != null) {
            head.next = reverseKGroup(next, k);
        }

        return prev;
    }

    public static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + (temp.next != null ? " -> " : ""));
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        int k = 2;
        head = reverseKGroup(head, k);
        print(head); // Output: 2 -> 1 -> 4 -> 3 -> 6 -> 5
    }
}
