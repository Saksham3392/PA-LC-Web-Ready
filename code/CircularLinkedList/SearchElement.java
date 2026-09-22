
public class SearchElement {
    static class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }

    public static boolean search(Node head, int target) {
        if (head == null) return false;

        Node temp = head;
        do {
            if (temp.val == target) return true;
            temp = temp.next;
        } while (temp != head);

        return false;
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = head; // Making it circular

        boolean found = search(head, 2);
        System.out.println("Element found: " + found);
    }
}