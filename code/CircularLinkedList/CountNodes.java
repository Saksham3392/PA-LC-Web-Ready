
public class CountNodes {
    static class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }

    public static int countNodes(Node head) {
        if (head == null) return 0;

        int count = 0;
        Node temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        return count;
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = head; // Making it circular

        int count = countNodes(head);
        System.out.println("Number of nodes in the circular linked list: " + count);
    }
}