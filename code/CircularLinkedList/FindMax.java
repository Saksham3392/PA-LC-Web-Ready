
public class FindMax {
    static class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }

    public static int findMax(Node head) {
        if (head == null) return Integer.MIN_VALUE;

        int max = head.val;
        Node temp = head.next;

        while (temp != head) {
            if (temp.val > max) {
                max = temp.val;
            }
            temp = temp.next;
        }

        return max;
    }
    public static void main(String[] args) {
        Node head = new Node(3);
        head.next = new Node(5);
        head.next.next = new Node(2);
        head.next.next.next = head; 

        int max = findMax(head);
        System.out.println("Maximum value in the circular linked list: " + max);
    }
}