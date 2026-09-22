
public class SecondLargest {
    static class Node {
        int val;
        Node prev;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }

    public static int findSecondLargest(Node head) {
        if (head == null || head.next == null) return -1;

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        Node curr = head;
        while (curr != null) {
            if (curr.val > first) {
                second = first;
                first = curr.val;
            } else if (curr.val > second && curr.val != first) {
                second = curr.val;
            }
            curr = curr.next;
        }

        return second == Integer.MIN_VALUE ? -1 : second;
    }
}